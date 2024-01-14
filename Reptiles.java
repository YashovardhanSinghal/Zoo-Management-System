package org.example;

public class Reptiles extends Animals {
    public Reptiles(String name) {
        super(name, "Reptile");
    }
    public Reptiles(String name, String noise, String animalHistory){
        super(name,"Reptile",noise,animalHistory);
    }
}

