import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;


public class Main {

    private static final Map<Integer, String> map = Consumer.myMap;
    private static Integer[] winnersUC = new Integer[10];
    //private static boolean alreadyWinner = false;
    private static int[] randomRaffled = new int[10];
    private static int random;
    public static Consumer consumer;
    private static WinningConsumer wc = new WinningConsumer(0,"",0);
    private static Object raffledItem = new Object();
    private static String[] raffledResult = new String[10];

    public static void main(String[] args) {
        ReadCSV.createObj();
        Map<Integer, String> myReadMap = ReadCSV.readMap;
        System.out.println("");
        initializeWinners();
        initializeRandomRaffled();
        prizeLoop();
        //showWinners();
        saveWinningConsumersToFile(raffledResult);
        System.out.println("========================================================================");

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

    private static void prizeLoop() {

        // Loop for each prize
        for (int i = 0; i < 10 ; i++) {
            System.out.println("  Clique ENTER para realizar o sorteio da " + (i + 1) + "a. Smart TV");
            try {
                System.in.read();
            } catch (IOException e) {
                System.out.println("An error has Occurred");
            }
//            alreadyWinner = false;
            // Random generation ====================

            int n = 0;
            random = new Random().nextInt(map.size());
            for (n = 0; n < randomRaffled.length; n++) {
                //System.out.println("winnersUC=" + winnersUC[i] + /* " / a=" + a +*/ " / random=" + random + " / randomRaffled[n]=" + randomRaffled[n]);

                while (randomRaffled[n] == random) {
//                    alreadyWinner = true;
                    n = 0;
                    System.out.println("    Consumidor já Sorteado, clique ENTER para novo Sorteio... " );
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        System.out.println("An error has Occurred");
                    }
                    random = new Random().nextInt(map.size());
                }
            }
            // ======================================

            // Save WinnerUC and RandomRaffled ======
            int j = 0;
            for(Map.Entry<Integer, String> entry : map.entrySet()) {
                if (j == random) {
                    System.out.println("    UC Contemplada: " + entry.getKey() + " de " + entry.getValue());
                    System.out.println();
                    winnersUC[i] = entry.getKey();
                    randomRaffled[i] = random;
                    wc.setPrizeNumber(i +1);
                    wc.setUc(entry.getKey());
                    wc.setName(entry.getValue());
                    saveWinningConsumer(wc, i);
                }
                j = j + 1;
            }
            // ======================================
        }
    }

    private static void saveWinningConsumer(WinningConsumer wc, int i) {
        raffledItem = wc.getPrizeNumber() + "a. Smart TV para UC: " + wc.getUc() + " de " + wc.getName();
        raffledResult[i] = (String) raffledItem;
    }

    private static void saveWinningConsumersToFile(String[] raffledResult) {
        // generating filename
        SimpleDateFormat date = new SimpleDateFormat("'Data_'yyyy-MM-dd'_Hora_'HH-mm-ss");
        Date systemDate = new Date();
        String filenameGenerated = date.format(systemDate);
        String outputFilename = String.format("Ganhandores-%s.txt", filenameGenerated);
        System.out.println("Arquivo Gerado: " + outputFilename);
        System.out.println("========================================================================");
        String resultTxt = "";
        for (String string: raffledResult) {
            resultTxt = resultTxt.concat(string).concat(" || ").concat("\n");
        }
        System.out.println(resultTxt);

        try {

            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(outputFilename), "utf-8"))) {
                writer.write(resultTxt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showWinners() {
        System.out.println("");
        for (int x: winnersUC) {
            System.out.print(x + " ");
        }
    }

    private void readMap() {
        // to test map reading
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

}



