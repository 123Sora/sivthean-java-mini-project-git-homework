package atm;

import account.Account;
import account.PayrollAccount;
import card.Card;
import card.CrebitCard;
import respository.SystemUserRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class BankATM implements ATMFeature {
    Account[] accounts;
    Card card;

    private void localAccount() {
        accounts = new Account[2];
        accounts[0] = new PayrollAccount(1001, "Siv", 90000, null);
        accounts[1] = new PayrollAccount(1002, "Thean", 80000, null);
    }

    @Override
    public void boot(String username, String password) {
        //set up card with accounts
        if (SystemUserRepository.getAdminUsers().getUsername().equals(username) && SystemUserRepository.getAdminUsers().getPassword().equals(password)) {
            //boot the atm
            //statically add the data to check
            localAccount();
            card = new CrebitCard();
            card.setAccount(accounts[0]);
            System.out.println("*".repeat(30));
            System.out.println("Successfully boot up the ATM");
            System.out.println("*".repeat(30));
        } else {
            System.out.println("=".repeat(40));
            System.out.println("Failed to boot ATM.Invalid Credential!!!");
            System.out.println("=".repeat(40));
        }
    }

    @Override
    public void shutdowm(String username, String password) {
        if (SystemUserRepository.getAdminUsers().getUsername().equals(username) && SystemUserRepository.getAdminUsers().getPassword().equals(password)) {
        //clear
          accounts = null;
          card = null;

        }else {
            System.out.println("Fail to shutdown !! wrong Credential!!");
        }
    }

    @Override
    public void pluginCard(Card card) {
        //use the account that we setup during boot as the owner of the card
        //in this case Siv is the owner of the card
        card.setAccount(this.card.getAccount());
        this.card = card;       //get information of card from user (main)
    }

    @Override
    public void plugoutCard() {
        this.card = null;
    }
    @Override
    public void doWithdraw() {
        Scanner scanner = new Scanner(System.in);
        if(card == null){
            System.out.println("Invalid Card!!");
            return;
        }
        System.out.println("Enter PIN : ");
        int pin = scanner.nextInt();
        if(LocalDate.now().isBefore(card.getExpiredAt()) && card.getPin()==pin){
            System.out.println("Enter your balance to withdraw : ");
            double amount = scanner.nextDouble();
            if(card.getLimitbalance()>=amount){
                card.getAccount().withdraw(amount);
            }else{
                System.out.println("Amount exceeded limited balance !");
            }

            showInfo();
        }else {
            System.out.println("Invalid Credentials!! can't withdraw ");
        }

    }

    @Override
    public void doDeposit() {
        Scanner scanner = new Scanner(System.in);
        if(card == null){
            System.out.println("Invalid Card!!");
            return;
        }
        System.out.println("Enter PIN : ");
        int pin = scanner.nextInt();
        if(LocalDate.now().isBefore(card.getExpiredAt()) && card.getPin()==pin){
            System.out.println("Enter money to Deposit : ");
            double amount = scanner.nextDouble();
            card.getAccount().deposit(amount);

            showInfo();
        }else{
            System.out.println("Invalid Credentials!! can't deposit!!");
        }

    }
    private void showInfo(){
        System.out.println("*".repeat(35));
        System.out.println("Account Name : "+card.getAccount().getOwner());
        System.out.println("Balance : "+card.getAccount().getBalance());
        System.out.println("Limit Balance : "+card.getLimitbalance());
        System.out.println("*".repeat(35));
    }
}
