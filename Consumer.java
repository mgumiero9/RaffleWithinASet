import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by mgumiero9 on 23/06/16.
 */
public class Consumer {

/*    public HashMap myHashMap;
    public HashSet myHashSet;*/

    public int uc = 0;
    public String name = "";

    public Consumer(int uc, String name) {

    }

    public static final Map<Integer, String> myMap;

    static
    {
        myMap = new HashMap<Integer, String>();
        myMap.put(1, "a");
        myMap.put(2, "b");
        myMap.put(3, "c");
        myMap.put(4, "d");
        myMap.put(5, "e");
        myMap.put(6, "f");
        myMap.put(7, "g");
    }

}
