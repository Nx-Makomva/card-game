package PapazKimde;

public class Computer extends Player{

    // override methods for automated behavior
    @Override
    public void removePairs() {
        // automatically remove pairs for computer player
    }

    @Override
    public void pullCardFrom(Player otherPlayer) {
        // automatically pull a card from another player's hand for computer player
    }

    // more methods specific to computer players
}
