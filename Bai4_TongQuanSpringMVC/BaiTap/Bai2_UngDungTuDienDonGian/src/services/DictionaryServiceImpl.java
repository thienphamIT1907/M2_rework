package services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    static Map<String, String> mapDictionary = new HashMap<>();

    static {


        mapDictionary.put("hello", "xin chào");
        mapDictionary.put("cloud", "đám mây");
        mapDictionary.put("home", "ngôi nhà");
    }

    @Override
    public String findWord(String keyword) {
        return mapDictionary.get(keyword);
    }
}
