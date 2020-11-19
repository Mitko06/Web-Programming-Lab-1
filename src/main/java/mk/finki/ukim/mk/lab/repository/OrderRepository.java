package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    public List<Order> getAllOrders(){
        return DataHolder.listOrders;
    }

    public Order placeOrder(String balloonColor, String balloonSize, String clientName, String address){
        Order newOrder = new Order(balloonColor,balloonSize,clientName,address);
        DataHolder.listOrders.add(newOrder);
        return newOrder;
    }
}
