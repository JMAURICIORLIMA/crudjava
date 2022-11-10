package com.senai.crudjava.domain;

import javax.persistence.*;
import java.time.Year;

@Entity
public class Manufacturer { //Fabricante

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand; //marca

    @Column(nullable = false)
    private String model; //modelo

    @Column(length = 4, nullable = false)
    private Year year; //ano

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;


    public Manufacturer() {
    }

    public Manufacturer(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Long id) {
        this.id = id;
    }
}
