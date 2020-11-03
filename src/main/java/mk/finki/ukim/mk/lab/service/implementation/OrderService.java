package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements mk.finki.ukim.mk.lab.service.OrderService {

    @Override
    public Order placeOrder(String balloonColor, String balloonSize, String clientName, String address) {
        return new Order(balloonColor,balloonSize,clientName,address,(long)1);
    }
}
