package org.example;

public class Animals {

    private String name;
    private String type;

    private String noise;

    private String animalHistory;



    public Animals(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public Animals(String name, String type, String noise, String animalHistory){
        this.name=name;
        this.type=type;
        this.noise=noise;
        this.animalHistory=animalHistory;
    }

    public String getAnimalHistory() {
        return animalHistory;
    }

    public void setAnimalHistory(String animalHistory) {
        this.animalHistory = animalHistory;
    }

    public String getNoise() {
        return noise;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void makeSound() {
        System.out.println("The " + type + " named " + name + " makes the following sound: " + noise);
    }

    public void describe() {
        System.out.println("Description of the " + type + " named " + name + ": " + animalHistory);
    }



    @Override
    public String toString() {
        return
                "\nName: " + name +
                 "\nTpe: " + type+
                "\nSound: " + noise +
                "\nDescription: " + animalHistory;
    }



}

