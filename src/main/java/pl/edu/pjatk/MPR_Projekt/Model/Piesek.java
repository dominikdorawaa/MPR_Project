package pl.edu.pjatk.MPR_Projekt.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Piesek {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String color;
    private String name;

private int identyfikator;

    public int getIdentyfikator() {
        return identyfikator;
    }

    public Piesek(String color, String name, int id) {
        this.color = color;
        this.name = name;
        this.id = id;
     this.identyfikator = obliczIdentyfikator();
    }
public Piesek(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
      this.identyfikator = obliczIdentyfikator();
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
       this.identyfikator = obliczIdentyfikator();
    }


    public int obliczIdentyfikator() {
        int sum = 0;


        for (int i = 0; i < name.length(); i++) {
            sum += (int) name.charAt(i);
        }


        for (int i = 0; i < color.length(); i++) {
            sum += (int) color.charAt(i);
        }

        return sum;
    }


}

