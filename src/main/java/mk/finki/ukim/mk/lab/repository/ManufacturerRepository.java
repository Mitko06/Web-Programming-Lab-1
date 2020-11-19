package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManufacturerRepository {
    public List<Manufacturer> findAll(){
        return DataHolder.listManufacturers;
    }
}
