package dev.wasabiTech;

import jakarta.persistence.*;

@Entity
@Table(name = "ProductColors")
public class ProductColors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Colors colors;


}
