package Utils;

import java.util.HashMap;
import java.util.Map;

public class Helper {
    public static Map<String, String> parseString(String str) {
        String[] sArr = str.split(",");
        Map<String, String> m = new HashMap<>();

        String[] item;
        String key, value;
        for (String s : sArr) {
            item = s.split(":");
            key = item[0];
            //    key = item[0].substring(0,1).toUpperCase() + item[0].substring(1).toLowerCase();
            if (item.length == 2) {
                value = item[1];
                //      value = item[1].substring(0, 1).toUpperCase() + item[1].substring(1).toLowerCase();
            } else value = "";

            String[] res = ExternalNormalizeString(key, value);
            m.put(res[0], res[1]);
        }
        return m;
    }


    // THIS IS EXTERNAL API to normalize string

    private static String[] ExternalNormalizeString(String item1, String item2) {
        String[] res = new String[2];
        try {
            Thread.sleep(1500);
            res[0] = item1.substring(0, 1).toUpperCase() + item1.substring(1).toLowerCase();
            res[1] = item2.substring(0, 1).toUpperCase() + item2.substring(1).toLowerCase();

        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return res;
    }

}

class myThread extends Thread {

    @Override
    public void run() {

    }
}