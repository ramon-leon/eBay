package Utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cache {

    private static Map<String, String> map = new HashMap<>();
//    private static Cache instance = new Cache();
//    private Cache() {
//    }

//    static Cache getInstance() {
//        return instance;
//    }
    public static Map<String, String> getMap() {
        return map;
    }

//    public static void setMap(Map<String, String> map) {
//        Cache.map = map;
//    }

}
