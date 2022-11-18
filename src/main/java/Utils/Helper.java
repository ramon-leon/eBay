package Utils;

import java.util.HashMap;
import java.util.Map;

public class Helper {
    public static Map<String, String> parseString(String str) {
        Map<String, String> m = new HashMap<>();
        if (str == null || str.length() == 0) {
            System.out.println("Unable to parse empty or null string");
            return m;
        }
        String[] sArr = str.split(",");

        String[] item;
        String key, value;
        for (String s : sArr) {
            item = s.split(":");
            key = item[0];
            if (item.length == 2) {
                value = item[1];
            } else value = "";

            // Basic implementation of caching every 'keyword' seen will be stored in the cache

            String[] res = new String[2];
            for (int i=0; i < 2; i++) {

                if (item.length == 2) {
                    key = item[i];
                } else key = "";

                Map<String, String> cacheMap = Cache.getMap();
                if (cacheMap.containsKey(key)) {
                    res[i] = cacheMap.get(key);
               //     m.put(key, cacheMap.get(key));
                } else {
                    String result = ExternalNormalizeString(key);
                    res[i] = result;
                    // stored this in the cache
                    cacheMap.put(key, result);
                }
            }
            m.put(res[0], res[1]);

        }
        return m;
    }


    // THIS IS EXTERNAL API to normalize string

    private static String ExternalNormalizeString(String item1) {
        System.out.println("CALL NORMALIZE");
        String res = "";
        try {
            Thread.sleep(1500);
            if (item1.length()>0) {
                res = item1.substring(0, 1).toUpperCase() + item1.substring(1).toLowerCase();
            }

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