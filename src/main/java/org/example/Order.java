package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private Customer customer;
    private Restaurant restaurant;
    private LocalDateTime orderTime;
    private LocalDateTime deliveryTime;
    private String deliveryAddress;
    private List<String> specialRequests;
    private boolean isPriority;

    public Order(String id, Customer customer, Restaurant restaurant,
                 LocalDateTime orderTime, LocalDateTime deliveryTime) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
        this.orderTime = orderTime;
        this.deliveryTime = deliveryTime;
        this.specialRequests = new ArrayList<>();
        this.isPriority = false;
    }

    // Геттеры и сеттеры
    public String getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Restaurant getRestaurant() { return restaurant; }
    public LocalDateTime getOrderTime() { return orderTime; }
    public LocalDateTime getDeliveryTime() { return deliveryTime; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public List<String> getSpecialRequests() { return specialRequests; }
    public boolean isPriority() { return isPriority; }

    public void addSpecialRequest(String request) {
        specialRequests.add(request);
    }

    public void setPriorityDelivery(boolean isPriority) {
        this.isPriority = isPriority;
    }
}