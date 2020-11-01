package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BalloonRepository {

    public List<Balloon> findAllBalloons(){

        return DataHolder.listBalloons;
    }

    public List<Balloon> findAllByNameOrDescription(String text){
        List<Balloon> foundBalloons = new ArrayList<>();
        for (Balloon balloon: DataHolder.listBalloons) {
            if (balloon.getName().toLowerCase().equals(text.toLowerCase())
                    || balloon.getDescription().toLowerCase().contains(text.toLowerCase())){
                foundBalloons.add(balloon);
            }
        }
        return foundBalloons;
    }

}
