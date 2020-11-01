package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements mk.finki.ukim.mk.lab.service.OrderService {
    public Order makeOrder;
    @Override
    public Order placeOrder(String balloonColor, String clientName, String address) {
        return new Order(balloonColor,"100",clientName,address,(long)111111111);
    }
}
