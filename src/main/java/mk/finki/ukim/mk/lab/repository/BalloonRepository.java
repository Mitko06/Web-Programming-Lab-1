package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
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

    public boolean saveBalloon(String name, String description, Manufacturer manufacturer){
        DataHolder.listBalloons.removeIf(r->r.getName().equals(name));
        return DataHolder.listBalloons.add(new Balloon(name,description,manufacturer));
    }

    public boolean deleteBalloon(Long id){
        return DataHolder.listBalloons.removeIf(r->r.getId().equals(id));
    }

    public Balloon getBalloon(Long id){
        return DataHolder.listBalloons.stream().filter(r->r.getId().equals(id)).findFirst().get();
    }

}
