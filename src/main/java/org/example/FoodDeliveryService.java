package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FoodDeliveryService {
    private List<Restaurant> restaurants;
    private List<Order> orders;

    public FoodDeliveryService() {
        this.restaurants = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    // Создание заказа (User Story 1)
    public Order createOrder(Customer customer, Restaurant restaurant,
                             LocalDateTime deliveryTime) {
        if (!restaurant.isAvailable()) {
            throw new IllegalStateException("Ресторан сейчас недоступен");
        }

        Order order = new Order("ORD" + (orders.size() + 1),
                customer, restaurant,
                LocalDateTime.now(), deliveryTime);
        orders.add(order);
        return order;
    }

    // Получение истории заказов клиента (User Story 2)
    public List<Order> getCustomerOrders(Customer customer) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomer().getId().equals(customer.getId())) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    // Добавление специальных запросов (User Story 3)
    public void addSpecialRequest(Order order, String request) {
        order.addSpecialRequest(request);
    }

    // Установка приоритетной доставки (User Story 4)
    public void setPriorityDelivery(Order order, boolean isPriority) {
        order.setPriorityDelivery(isPriority);
    }

    // Установка адреса доставки (User Story 5)
    public void setDeliveryAddress(Order order, String address) {
        order.setDeliveryAddress(address);
    }
}