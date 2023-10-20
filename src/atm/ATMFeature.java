package atm;

import card.Card;

public interface ATMFeature {
    void boot(String username, String password);
    void shutdowm(String username , String password);
    void pluginCard(Card card);
    void plugoutCard();
    void doWithdraw();
    void doDeposit();


}
