package services;

import models.Sanwich;
import org.springframework.stereotype.Service;


import java.util.Arrays;

@Service
public class SanwichServiceImpl implements SanwichService {

    @Override
    public String cookingSanwich(Sanwich sw) {
        return Arrays.toString(sw.getCondiments());
    }

    @Override
    public Boolean isEmptyCondiments(String[] listCondiments) {
        int limit = 0;
        for(String condiment: listCondiments) {
            if(condiment == null) {
                limit++;
                if (limit == listCondiments.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
