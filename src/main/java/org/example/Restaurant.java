package org.example;

public class Restaurant {
    private String id;
    private String name;
    private boolean isAvailable;
    private double deliveryFee;

    public Restaurant(String id, String name, double deliveryFee) {
        this.id = id;
        this.name = name;
        this.deliveryFee = deliveryFee;
        this.isAvailable = true;
    }

    // Геттеры и сеттеры
    public String getId() { return id; }
    public String getName() { return name; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public double getDeliveryFee() { return deliveryFee; }
}
