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

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public List<ProductColors> getColorList() {
        return colorList;
    }

    public void setColorList(List<ProductColors> colorList) {
        this.colorList = colorList;
    }

    public java.lang.String getColorName() {
        return colorName;
    }

    public void setColorName(java.lang.String colorName) {
        this.colorName = colorName;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Colors{" +
                "id=" + id +
                ", colorName=" + colorName +
                '}';
    }
}