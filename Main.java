import java.io.IOException;
import java.util.*;

public class Main {

    public static HashMap myHashMap;
    public static HashSet myHashSet;

    private static final Map<Integer, String> map = Consumer.myMap;

    public static void main(String[] args) {
        System.out.println("");
        prizeLoop();
    }

    public static void raffle() {
        int item = new Random().nextInt(map.size()); // In real life, the Random object should be rather more shared than this
        int i = 0;
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            if (i == item) {
                //  return obj
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        i = i + 1;
        }
    }

    public static void readMap() {
        // to test map reading
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
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
            raffle();
        }
    }

}



