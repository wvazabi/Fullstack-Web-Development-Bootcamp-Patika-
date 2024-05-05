package dev.wasabiTech;

import jakarta.persistence.*;

@Entity
@Table(name="codes")
public class Code{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id", columnDefinition = "serial")
    private int id;

    @Column(name = "code_group", nullable = false)
    private String group;

    @Column(name = "code_serial", nullable = false)
    private String serial;

    // Code da kendi içersinde product'a sahip mappedby kısmına nesnein adını veriyoruz.
    //JPA mappedby görünce joine gidip bakar
    @OneToOne(mappedBy = "code")
    private Product product;

    public Code() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getGroup() {
        return group;
    }

    public void setGroup(java.lang.String group) {
        this.group = group;
    }

    public java.lang.String getSerial() {
        return serial;
    }

    public void setSerial(java.lang.String serial) {
        this.serial = serial;
    }

    // product toString içersinde bastırılmıyor one to one ilişkilerde hata ile karşılaşılabilir
    @java.lang.Override
    public java.lang.String toString() {
        return "Code{" +
                "id=" + id +
                ", group=" + group +
                ", serial=" + serial +
                '}';
    }
}
