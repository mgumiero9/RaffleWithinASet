/**
 * Created by mgumiero9 on 23/06/16.
 * This class is about the winner consumer and the position (ordinary) on the raffle.
 */
class WinningConsumer extends Consumer {
    public WinningConsumer(int uc, String nome) {
        super(uc, nome);
    }

    private int prizeNumber = 0;

    WinningConsumer(int uc, String nome, int prizeNumber) {
        super(uc, nome);
        this.prizeNumber = prizeNumber;

    }

    int getPrizeNumber() {
        return prizeNumber;
    }

    void setPrizeNumber(int prizeNumber) {
        this.prizeNumber = prizeNumber;
    }
}




