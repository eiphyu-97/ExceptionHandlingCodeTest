package com.code.test.demo.domain;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

public class Product {

    @Digits(integer = 6 ,fraction = 0 , message = "Id should be up to 6 digits.")
    private int prodId;

    @NotNull(message = "Product name cannot be null.")
    private String name;

    @Digits(integer = 10,fraction = 2 , message = "Maximum price should be up to 10 digit and 2 fraction.")
    private double price;

    public Product(int prodId, String name, double price) {
        this.prodId = prodId;
        this.name = name;
        this.price = price;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
