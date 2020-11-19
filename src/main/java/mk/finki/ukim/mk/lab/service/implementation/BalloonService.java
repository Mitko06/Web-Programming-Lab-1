package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.BalloonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BalloonService implements mk.finki.ukim.mk.lab.service.BalloonService {

    BalloonRepository repository = new BalloonRepository();

    @Override
    public List<Balloon> listAll() {
        return repository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return repository.findAllByNameOrDescription(text);
    }

    @Override
    public boolean saveBalloon(Long id,String name, String description, Manufacturer manufacturer) {
        return repository.saveBalloon(name,description,manufacturer);
    }

    @Override
    public boolean deleteBalloon(Long id) {
        return repository.deleteBalloon(id);
    }

    @Override
    public Balloon getBalloon(Long id) {
        return repository.getBalloon(id);
    }
}