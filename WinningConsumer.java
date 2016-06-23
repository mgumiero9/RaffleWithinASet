/**
 * Created by mgumiero9 on 23/06/16.
 */
public class WinningConsumer extends Consumer {
    public WinningConsumer(int uc, String nome) {
        super(uc, nome);
    }

    public int prizeNumber = 0;

    public WinningConsumer(int uc, String nome, int prizeNumber) {
        super(uc, nome);
        this.prizeNumber = prizeNumber;


    }
}




