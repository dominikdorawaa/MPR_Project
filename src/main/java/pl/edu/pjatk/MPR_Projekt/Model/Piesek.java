package pl.edu.pjatk.MPR_Projekt.Model;

public class Piesek {
    private String color;
    private String name;


    public Piesek(String color, String name) {
        this.color = color;
        this.name = name;
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

