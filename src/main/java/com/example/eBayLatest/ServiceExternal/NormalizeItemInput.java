package com.example.eBayLatest.ServiceExternal;

import Utils.Helper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NormalizeItemInput {

    public Map<String, String> normalizeItemSpecific(String specific) {
        Map<String, String> map;
        // Convert from following format:
        //
        // "Model:Civic,MAkE:hONDA,Color:BLUE"
        // To key value pairs

        map = Helper.parseString(specific);


        return map;
    }
}
