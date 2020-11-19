package mk.finki.ukim.mk.lab.bootstrap;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Balloon> listBalloons = new ArrayList<>();
    public static List<Manufacturer> listManufacturers = new ArrayList<>();
    public static List<Order> listOrders=new ArrayList<>();
    @PostConstruct
    public void init(){

        listManufacturers.add(new Manufacturer("Sony","United States","Address no.1"));
        listManufacturers.add(new Manufacturer("Nike","United States","Address no.2"));
        listManufacturers.add(new Manufacturer("VW","Germany","Address no.3"));
        listManufacturers.add(new Manufacturer("Microsoft","United States","Address no.4"));
        listManufacturers.add(new Manufacturer("Apple","United States","Address no.5"));

        listBalloons.add(new Balloon("Red","This is Red balloon",listManufacturers.get(1)));
        listBalloons.add(new Balloon("Blue","This is Blue balloon",listManufacturers.get(2)));
        listBalloons.add(new Balloon("Yellow","This is Yellow balloon",listManufacturers.get(3)));
        listBalloons.add(new Balloon("Green","This is Green balloon",listManufacturers.get(3)));
        listBalloons.add(new Balloon("Brown","This is Brown balloon",listManufacturers.get(0)));
        listBalloons.add(new Balloon("Black","This is Black balloon",listManufacturers.get(1)));
        listBalloons.add(new Balloon("White","This is White balloon",listManufacturers.get(2)));
        listBalloons.add(new Balloon("Cyan","This is Cyan balloon",listManufacturers.get(3)));
        listBalloons.add(new Balloon("Grey","This is Grey balloon",listManufacturers.get(3)));
        listBalloons.add(new Balloon("Purple","This is Purple balloon",listManufacturers.get(3)));



    }
}
