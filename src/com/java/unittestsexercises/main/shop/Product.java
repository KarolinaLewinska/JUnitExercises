package com.java.unittestsexercises.main.shop;

public class Product {
    private String title;
    private double price;

    public Product (String t, double p) {
        this.title = t;
        this.price = p;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public boolean equals(Object o) {
        if (o instanceof Product p) {
            return p.getTitle().equals(title);
        }
        return false;
    }
}