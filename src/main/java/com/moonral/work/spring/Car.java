package com.moonral.work.spring;

/**
 * @author 江梦原
 * @date 2022-08-24
 */
public class Car {

    private String brand;
    private double price;
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Car [brand=" + brand + ", price=" + price + "]";
    }
}
