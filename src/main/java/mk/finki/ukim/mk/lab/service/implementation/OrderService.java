package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements mk.finki.ukim.mk.lab.service.OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order placeOrder(String balloonColor, String balloonSize, String clientName, String address) {
        return repository.placeOrder(balloonColor,balloonSize,clientName,address);
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.getAllOrders();
    }
}
