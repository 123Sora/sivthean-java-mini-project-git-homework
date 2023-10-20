package account;

import card.Card;

public class PayrollAccount extends Account {
    public PayrollAccount(){}
    public PayrollAccount(int id , String owner , double balance ,Card card){
        super(id , owner, balance, card);

    }
    @Override
    public double withdraw(double balance) {
        if(this.getBalance()>=balance){
            this.setBalance(this.getBalance()-balance);
        }else {
            System.out.println("Not Enough Balance!!!");
        }

        return this.getBalance();
    }

    @Override
    public void deposit(double balance) {
        //tax = 20%
        balance = balance * 0.8;
        this.setBalance(this.getBalance()+balance);

    }
}
