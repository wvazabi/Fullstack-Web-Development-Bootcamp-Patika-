public abstract class Product {
    int price;

    int discountRatio;
    int stock;

    public Product(int price, int discountRatio, int stock, String productName, String brandName, int screenSize, int ram) {
        this.price = price;
        this.discountRatio = discountRatio;
        this.stock = stock;
        this.productName = productName;
        this.brandName = brandName;
        this.screenSize = screenSize;
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountRatio() {
        return discountRatio;
    }

    public void setDiscountRatio(int discountRatio) {
        this.discountRatio = discountRatio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    String productName;

    String brandName;

    int screenSize;
    int ram;

}

