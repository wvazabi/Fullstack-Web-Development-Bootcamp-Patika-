package dev.wasabiTech;

public class CheapProduct {

        private int id;

        private String prodName;
        private Double prodPrice;

        // Getter and Setter methods

    public CheapProduct(int id, String prodName, Double prodPrice) {
        this.id = id;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
    }

    @Override
    public String toString() {
        return "CheapProduct{" +
                "id=" + id +
                ", prodName='" + prodName + '\'' +
                ", prodPrice=" + prodPrice +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }
}
