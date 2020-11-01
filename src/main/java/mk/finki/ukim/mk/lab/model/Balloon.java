package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Balloon {
    public String name;
    public String description;

    public Balloon(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
