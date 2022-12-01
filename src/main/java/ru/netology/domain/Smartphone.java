package ru.netology.domain;

public class Smartphone extends Product {
    private String manufacturer;
    private String os;

    public Smartphone() {
    }

    public Smartphone(int id, String name, int cost, String manufacturer, String os) {
        super(id, name, cost);
        this.manufacturer = manufacturer;
        this.os = os;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
