package com.cbs.hibernate.crud.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//http://localhost:8080/products
@Entity
@Table(name = "Products")
public class Products {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Quality should be greater than 0")
    @Column(name = "quality")
    private int quality;

    @Min(value = 0, message = "Price should be greater than 0")
    @Column(name = "price")
    private float price;

    @Min(value = 1900, message = "Year of production should be greater than 1900")
    @Column(name = "year")
    private int year;

    @Column(name = "producer")
    @NotEmpty(message = "Producer should not be empty")
    @Size(min = 2, max = 100, message = "Producer should be between 2 and 100 characters")
    private String producer;

    public Products() {

    }

    public Products(String name, int quality, float price, int year, String producer) {
        this.name = name;
        this.quality = quality;
        this.price = price;
        this.year = year;
        this.producer = producer;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public float getPrice() { return price; }

    public void setPrice(float price) { this.price = price; }

    public int getYear() { return year;}

    public void setYear(int year) { this.year = year;}

    public String getProducer() { return producer; }

    public void setProducer(String producer) { this.producer = producer; }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quality=" + quality + '\'' +
                ", price='" + price + '\'' +
                ", year=" + year + '\'' +
                ", producer='" + producer +
                '}';
    }
}
