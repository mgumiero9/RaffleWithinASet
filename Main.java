import java.io.IOException;
import java.util.Map;
import java.util.Random;


public class Main {

    public static final Map<Integer, String> map = Consumer.myMap;
    public static Integer[] winnersUC = new Integer[10];
    private static boolean alreadyWinner = false;
    private static int[] randomRaffled = new int[10];
    public static int random;

    public static void main(String[] args) {
        System.out.println("");
        initializeWinners();
        initializeRandomRaffled();
        prizeLoop();
        showWinners();
        System.out.println("");
    }

    private static void initializeWinners() {
        for (int k = 0; k < winnersUC.length; k++) {
            winnersUC[k] = 0;
        }
    }

    private static void initializeRandomRaffled() {
        for (int k = 0; k < randomRaffled.length; k++) {
            randomRaffled[k] = 9999999;
        }
    }

    public static void prizeLoop() {

        // Loop for each prize
        for (int i = 0; i < 10 ; i++) {
            System.out.print("Clique ENTER para realizar o sorteio da " + (i + 1) + "a. Smart TV");
            try {
                System.in.read();
            } catch (IOException e) {
                System.out.println("An error has Occurred");
            }
            alreadyWinner = false;

            // Random generation ====================

            int n = 0;
            random = new Random().nextInt(map.size()); // In real life, the Random object should be rather more shared than this
            for (n = 0; n < randomRaffled.length; n++) {
                System.out.println("winnersUC=" + winnersUC[i] + /* " / a=" + a +*/ " / random=" + random + " / randomRaffled[n]=" + randomRaffled[n]);

                while (randomRaffled[n] == random) {
                    alreadyWinner = true;
                    n = 0;
                    System.out.println("Already WINNER");
                    random = new Random().nextInt(map.size()); // In real life, the Random object should be rather more shared than this
                }
            }
            // ======================================


            // Save WinnerUC and RandomRaffled ======
            int j = 0;
            for(Map.Entry<Integer, String> entry : map.entrySet()) {
                //if ((j == random) && (!alreadyWinner)) {
                if (j == random) {
                    //  return obj
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                    winnersUC[i] = entry.getKey();
                    randomRaffled[i] = random;
                    //System.out.println("winnersUC=" + winnersUC[i] + " / randomRaffled=" + randomRaffled[i]);
                }
                j = j + 1;
            }
            // ======================================
        }
    }

    public static void showWinners() {
        System.out.println("");
        for (int x: winnersUC) {
            System.out.print(x + " ");
        }
    }

    public void readMap() {
        // to test map reading
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

}



