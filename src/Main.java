import atm.ATMFeature;
import atm.BankATM;
import card.Card;
import card.CrebitCard;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        ATMFeature atm = new BankATM();
        atm.boot("admin","password123");

        Card card = new CrebitCard();
        card.setPin(6666);
        card.setIssueAt(LocalDate.now());
        card.setExpiredAt(card.getIssueAt().plus(2, ChronoUnit.YEARS));
        card.setLimitbalance(200);

        //plug card to the atm
        atm.pluginCard(card);
        atm.doDeposit();
        atm.doWithdraw();
    }
}
