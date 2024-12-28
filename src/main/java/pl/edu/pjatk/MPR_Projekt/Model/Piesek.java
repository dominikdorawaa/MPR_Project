package pl.edu.pjatk.MPR_Projekt.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@Getter
@ToString
@Entity
public class Piesek {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String color;

    private String name;

    private int identyfikator;


    public Piesek(String color, String name) {
        this.color = color;
        this.name = name;
        setIdentyfikator();
    }

    public void setColor(String color) {
        this.color = color;
        setIdentyfikator();
    }

    public void setName(String name) {
        this.name = name;
        setIdentyfikator();
    }

    public void setId(int id) {
        this.id = id;
        setIdentyfikator();
    }

    public void setIdentyfikator() {
        int sum = 0;
        if (name != null) {
            for (int i = 0; i < name.length(); i++) {
                sum += (int) name.charAt(i);
            }
        }
        if (color != null) {
            for (int i = 0; i < color.length(); i++) {
                sum += (int) color.charAt(i);
            }
        }
            this.identyfikator = sum;
        }
    }

