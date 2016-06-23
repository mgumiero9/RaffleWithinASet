import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Main {

    public static HashMap myHashMap;
    public static HashSet myHashSet;

    public static void main(String[] args) {
        System.out.println("");

        for (int i = 0; i < 10 ; i++) {
            System.out.println("Clique ENTER para realizar o sorteio da " + (i + 1) + "a. Smart TV");
            try {
                System.in.read();
            } catch (IOException e) {
                System.out.println("An error has Occurred");
            }
        }

    }

    public void raffle() {

        int size = myHashSet.size();
        int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
        int i = 0;
        for(Object obj : myHashSet)
        {
            if (i == item)
            //    return obj;
            i = i + 1;
        }

    }
}



