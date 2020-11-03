package mk.finki.ukim.mk.lab.bootstrap;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Balloon> listBalloons = new ArrayList<>();
    @PostConstruct
    public void init(){
        listBalloons.add(new Balloon("Red","This is Red balloon"));
        listBalloons.add(new Balloon("Blue","This is Blue balloon"));
        listBalloons.add(new Balloon("Yellow","This is Yellow balloon"));
        listBalloons.add(new Balloon("Green","This is Green balloon"));
        listBalloons.add(new Balloon("Brown","This is Brown balloon"));
        listBalloons.add(new Balloon("Black","This is Black balloon"));
        listBalloons.add(new Balloon("White","This is White balloon"));
        listBalloons.add(new Balloon("Cyan","This is Cyan balloon"));
        listBalloons.add(new Balloon("Grey","This is Grey balloon"));
        listBalloons.add(new Balloon("Purple","This is Purple balloon"));
    }
}
