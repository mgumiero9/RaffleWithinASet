import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mgumiero9 on 27/06/16.
 */
public class ReadCSV {

    public static void createObj() {

        ReadCSV obj = new ReadCSV();
        obj.run();

    }

    public void run() {

        String csvFile = "ucs_sorteio_v2.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ";";

        try {

            Map<Integer, String> readMap = new HashMap<Integer, String>();

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use semicolon as separator
                String[] myLine = line.split(csvSplitBy);
                Integer myKey = Integer.parseInt(myLine[0]);
                String myValue = myLine[1];

                readMap.put(myKey, myValue);

            }

            //loop map
            for (Map.Entry<Integer, String> entry : readMap.entrySet()) {

                System.out.println("UC=" + entry.getKey() + " , nome="
                        + entry.getValue());

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");
    }

}
