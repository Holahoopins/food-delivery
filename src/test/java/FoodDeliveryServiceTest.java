import org.example.Customer;
import org.example.FoodDeliveryService;
import org.example.Order;
import org.example.Restaurant;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FoodDeliveryServiceTest {
    @Test
    void testCreateOrder() {
        FoodDeliveryService service = new FoodDeliveryService();
        Customer customer = new Customer("C1", "Nван", "ул. Ленина 10", "+79123456789");
        Restaurant restaurant = new Restaurant("R1", "Пицца Марио", 150.0);
        service.addRestaurant(restaurant);

        LocalDateTime deliveryTime = LocalDateTime.now().plusHours(1);
        Order order = service.createOrder(customer, restaurant, deliveryTime);

        assertNotNull(order);
        assertEquals(customer, order.getCustomer());
        assertEquals(restaurant, order.getRestaurant());
    }

    @Test
    void testGetCustomerOrders() {
        FoodDeliveryService service = new FoodDeliveryService();
        Customer customer = new Customer("C2", "Мария", "ул. Пушкина 15", "+79123456780");
        Restaurant restaurant1 = new Restaurant("R1", "Бургер Кинг", 100.0);
        Restaurant restaurant2 = new Restaurant("R2", "КФС", 120.0);
        service.addRestaurant(restaurant1);
        service.addRestaurant(restaurant2);

        service.createOrder(customer, restaurant1, LocalDateTime.now().plusHours(1));
        service.createOrder(customer, restaurant2, LocalDateTime.now().plusHours(2));

        List<Order> orders = service.getCustomerOrders(customer);
        assertEquals(2, orders.size());
        assertEquals("Мария", orders.get(0).getCustomer().getName());
    }

    @Test
    void testSpecialRequests() {
        FoodDeliveryService service = new FoodDeliveryService();
        Customer customer = new Customer("C3", "Алексей", "пр. Мира 20", "+79123456781");
        Restaurant restaurant = new Restaurant("R3", "Суши Вок", 200.0);
        service.addRestaurant(restaurant);

        Order order = service.createOrder(customer, restaurant, LocalDateTime.now().plusHours(1));
        service.addSpecialRequest(order, "Без лука");
        service.addSpecialRequest(order, "Острый соус");

        List<String> requests = order.getSpecialRequests();
        assertEquals(2, requests.size());
        assertTrue(requests.contains("Без лука"));
    }

    @Test
    void testPriorityDelivery() {
        FoodDeliveryService service = new FoodDeliveryService();
        Customer customer = new Customer("C4", "Ольга", "ул. Гагарина 5", "+79123456782");
        Restaurant restaurant = new Restaurant("R4", "Додо Пицца", 180.0);
        service.addRestaurant(restaurant);

        Order order = service.createOrder(customer, restaurant, LocalDateTime.now().plusHours(1));
        service.setPriorityDelivery(order, true);

        assertTrue(order.isPriority());
    }

    @Test
    void testDeliveryAddress() {
        FoodDeliveryService service = new FoodDeliveryService();
        Customer customer = new Customer("C5", "Дмитрий", "ул. Чехова 3", "+79123456783");
        Restaurant restaurant = new Restaurant("R5", "Теремок", 90.0);
        service.addRestaurant(restaurant);

        Order order = service.createOrder(customer, restaurant, LocalDateTime.now().plusHours(1));
        service.setDeliveryAddress(order, "ул. Чехова 3, кв. 42");

        assertEquals("ул. Чехова 3, кв. 42", order.getDeliveryAddress());
    }
}