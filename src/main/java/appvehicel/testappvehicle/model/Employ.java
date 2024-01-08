package appvehicel.testappvehicle.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employs")
public class Employ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "no_reg", nullable = false)
    private String noReg;
    @Column(name = "name_user")
    private String nameUser;
    @Column(name = "vcl_brand")
    private String vclBrand;
    @Column(name = "years_om")
    private String yearsOM;
    @Column(name = "capacity")
    private String capacity;
    @Column(name = "color")
    private String color;
    @Column(name = "fuel")
    private String fuel;
    @Column(name = "owner_address")
    private String address;

}
