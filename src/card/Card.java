package card;

import account.Account;
import account.PayrollAccount;

import java.time.LocalDate;

public  abstract class Card {
    private int pin; // code
    private LocalDate issueAt;
    private LocalDate expiredAt;
    private double limitbalance;
    private Account account;
    public Card(){
        //provide reference to the account
        account = new PayrollAccount();
    }
    public Card(int pin , LocalDate issueAt, LocalDate expiredAt, double limitbalance, Account account){
        this.pin = pin;
        this.issueAt = issueAt;
        this.expiredAt = expiredAt;
        this.limitbalance = limitbalance;
        this.account = account;
    }
    //setter and getter

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public LocalDate getIssueAt() {
        return issueAt;
    }

    public void setIssueAt(LocalDate issueAt) {
        this.issueAt = issueAt;
    }

    public LocalDate getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(LocalDate expiredAt) {
        this.expiredAt = expiredAt;
    }

    public double getLimitbalance() {
        return limitbalance;
    }

    public void setLimitbalance(double limitbalance) {
        this.limitbalance = limitbalance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
