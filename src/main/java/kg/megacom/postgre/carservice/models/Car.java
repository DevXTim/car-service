package kg.megacom.postgre.carservice.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Getter
@Setter
@ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String manufacturer;
    private String model;
    private int year;
    private String color;
    private double price;
    private double volume;
//    @Column(name = "horse_power")
    private int horsePower;
}
