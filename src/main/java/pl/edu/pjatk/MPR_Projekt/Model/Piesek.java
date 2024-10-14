package pl.edu.pjatk.MPR_Projekt.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Piesek {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String color;
    private String name;
    private int id;
private long identyfikator;

    public Piesek(String color, String name,int id) {
        this.color = color;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }
}

