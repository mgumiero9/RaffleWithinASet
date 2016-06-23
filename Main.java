import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Main {

    public static HashMap myHashMap;
    public static HashSet myHashSet;

    public static void main(String[] args) {
        System.out.println("Hello World!");

    }

    public void raffle() {

        int size = myHashSet.size();
        int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
        int i = 0;
        for(Object obj : myHashSet)
        {
            if (i == item)
                return obj;
            i = i + 1;
        }

    }
}



