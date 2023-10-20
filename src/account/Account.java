package account;

import card.Card;

public  abstract class Account implements Transaction  {
    private int id ;
    private String owner ;
    private double balance ;
    private Card card ;
    public Account(){}

    public Account(int id , String owner, Double balance, Card card){
        this.id = id ;
        this.owner = owner ;
        this.balance = balance;
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
