package models;

public class Sanwich {
    private String[] condiments;

    public Sanwich() {
    }

    public Sanwich(String[] condiments) {
        this.condiments = condiments;
    }

    public String[] getCondiments() {
        return condiments;
    }

    public void setCondiments(String[] condiments) {
        this.condiments = condiments;
    }
}
