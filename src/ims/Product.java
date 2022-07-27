package ims;

import java.util.Arrays;
import java.util.List;

public class Product {
    public enum Color {
        BLACK,
        WHITE,
    }

    public enum Size {
        SMALL,
        REGULAR,
        LARGE
    }

    private int id;
    private String name;
    private Color color;
    private Size size;

    private int stock;

    public Product() {
        this.stock = 0;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color=" + color +
                ", size=" + size +
                ", stock=" + stock +
                '}';
    }
}
