package pl.edu.pjatk.MPR_Projekt.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@ToString
@Entity
public class Piesek {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    private Integer id;

    @Setter
    private String color;
    @Setter
    private String name;

    private int identyfikator;


    public Piesek(String color, String name) {
        this.color = color;
        this.name = name;
        setIdentyfikator();
    }


    public void setIdentyfikator() {
        int sum = 0;
        for (int i = 0; i < name.length(); i++) {
            sum += (int) name.charAt(i);
        }
        for (int i = 0; i < color.length(); i++) {
            sum += (int) color.charAt(i);
        }
        this.identyfikator = sum;
    }
}
