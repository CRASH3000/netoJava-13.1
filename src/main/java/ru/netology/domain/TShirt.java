package ru.netology.domain;

public class TShirt extends Product {

    private String color;
    private String size;

    public TShirt() {
    }

    public TShirt(int id, String name, int cost, String color, String size) {
        super(id, name, cost);
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String size) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
