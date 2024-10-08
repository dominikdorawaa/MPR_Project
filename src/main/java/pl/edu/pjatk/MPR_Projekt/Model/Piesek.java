package pl.edu.pjatk.MPR_Projekt.Model;

public class Piesek {
    private String color;
    private String name;
    private int id;



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

