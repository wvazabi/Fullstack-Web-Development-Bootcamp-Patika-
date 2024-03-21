public class Notebook extends Product{

    int Storage;

    public Notebook(int price, int discountRatio, int stock, String productName, String brandName, int screenSize, int ram, int storage) {
        super(price, discountRatio, stock, productName, brandName, screenSize, ram);
        Storage = storage;
    }
}
