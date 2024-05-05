package dev.wasabiTech;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "colors")
public class Colors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "color_name", nullable = false)
    private String name;

   @ManyToMany(mappedBy = "colorList")
   private List<Product> productList;

    public Colors() {
    }

    public Colors(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Colors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}