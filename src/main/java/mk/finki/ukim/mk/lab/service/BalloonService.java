package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;

import java.util.List;


public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
    boolean saveBalloon(Long id, String name, String description, Manufacturer manufacturer);
    boolean deleteBalloon(Long id);
    Balloon getBalloon(Long id);
}