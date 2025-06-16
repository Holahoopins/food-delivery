package org.example;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Nнициализация сервиса доставки
        FoodDeliveryService deliveryService = new FoodDeliveryService();

        // Создание ресторанов
        Restaurant pizzaRestaurant = new Restaurant("R1", "Пицца Челентано", 150.0);
        Restaurant sushiRestaurant = new Restaurant("R2", "Суши Wok", 200.0);
        deliveryService.addRestaurant(pizzaRestaurant);
        deliveryService.addRestaurant(sushiRestaurant);

        // Регистрация клиентов
        Customer customer1 = new Customer("C1", "Nван Nванов", "ул. Ленина, 10", "+79123456789");
        Customer customer2 = new Customer("C2", "Мария Петрова", "пр. Мира, 15", "+79098765432");

        // Создание заказов
        Order order1 = deliveryService.createOrder(
                customer1,
                pizzaRestaurant,
                LocalDateTime.now().plusHours(1)
        );
        deliveryService.setDeliveryAddress(order1, "ул. Ленина, 10, кв. 5");
        deliveryService.addSpecialRequest(order1, "Без лука");
        deliveryService.addSpecialRequest(order1, "Дополнительный сыр");

        Order order2 = deliveryService.createOrder(
                customer2,
                sushiRestaurant,
                LocalDateTime.now().plusHours(2)
        );
        deliveryService.setDeliveryAddress(order2, "пр. Мира, 15, кв. 12");
        deliveryService.addSpecialRequest(order2, "Палочки вместо вилки");
        deliveryService.setPriorityDelivery(order2, true);

        // Вывод информации о заказах
        System.out.println("===Nнформация о заказах===");
        printOrderInfo(order1);
        printOrderInfo(order2);

        // Получение истории заказов клиента
        System.out.println("\n===история заказов клиента" + customer1.getName() + "===");
        List<Order> customer1Orders = deliveryService.getCustomerOrders(customer1);
        for (Order order : customer1Orders) {
            printOrderInfo(order);
        }
    }

    private static void printOrderInfo(Order order) {
        System.out.println("\nЗаказ #" + order.getId());
        System.out.println("Клиент: " + order.getCustomer().getName());
        System.out.println("Ресторан: " + order.getRestaurant().getName());
        System.out.println("Адрес доставки: " + order.getDeliveryAddress());
        System.out.println("Время заказа: " + order.getOrderTime());
        System.out.println("Ожидаемое время доставки: " + order.getDeliveryTime());
        System.out.println("Специальные запросы: " + String.join(", ", order.getSpecialRequests()));
        System.out.println("Приоритетная доставка: " + (order.isPriority() ? "Да" : "Нет"));
    }
}