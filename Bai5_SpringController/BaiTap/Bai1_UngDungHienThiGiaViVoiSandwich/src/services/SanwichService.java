package services;

import models.Sanwich;

public interface SanwichService {

    String cookingSanwich(Sanwich sw);

    Boolean isEmptyCondiments(String[] listCondiments);
}
