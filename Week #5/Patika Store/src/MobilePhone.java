public class MobilePhone extends Product{
    int mobilePhoneMemory;
    int batteryPower;
    String color;

    public MobilePhone(int price, int discountRatio, int stock, String productName, String brandName, int screenSize, int ram, int mobilePhoneMemory, int batteryPower, String color) {
        super(price, discountRatio, stock, productName, brandName, screenSize, ram);
        this.mobilePhoneMemory = mobilePhoneMemory;
        this.batteryPower = batteryPower;
        this.color = color;
    }



}
