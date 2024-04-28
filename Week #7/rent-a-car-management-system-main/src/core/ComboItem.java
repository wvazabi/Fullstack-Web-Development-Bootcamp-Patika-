package core;

//TODO seçilen değerin keyi ve ekrana gösterilen değerini birlikte tutmak için

public class ComboItem {

    private int key;
    private String value;

    public ComboItem(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public ComboItem(String str) {
        this.value = str;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
