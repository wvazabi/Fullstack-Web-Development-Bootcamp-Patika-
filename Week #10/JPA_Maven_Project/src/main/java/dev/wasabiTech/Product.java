package dev.wasabiTech;

import jakarta.persistence.*;



@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition = "serial")
    private int id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_prc")
    private Double price;

    @Column(name = "product_stock", nullable = false)
    private int stock;

    //product'ın bir codu varsa code entitysinde üretilmis bir nesneyi kendi özelliğmiş gibi alabilir.
    // bundle olarak belirliyoruz
   // JoinColumn u görünce JPA mappedbyla join yapar
    @OneToOne
    @JoinColumn(name = "product_code_id", referencedColumnName = "code_id")
    private Code code;

    //Supplier ile çoktan aza bir ilişkisi var
    @ManyToOne
    @JoinColumn(name = "product_supplier_id", referencedColumnName = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "product_category_id", referencedColumnName = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "pro2colors",
            joinColumns = @JoinColumn(name = "pro2colors_product_id"),
            inverseJoinColumns = @JoinColumn(name = "pro2colors_color_id"))
    private List<Colors> colorList;
}

    // Diğer özellikler ve getter/setter metotları



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.Double getPrice() {
        return price;
    }

    public void setPrice(java.lang.Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Product{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", stock=" + stock +
                ", code=" + code +
                ", supplier=" + supplier +
                ", category=" + category +
                '}';
    }

}