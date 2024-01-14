package org.example;

public class Mammals extends Animals {

    public Mammals(String name){
        super(name,"Mammal");
    }
    public Mammals(String name,String noise,String animalHistory) {
        super(name, "Mammal",noise,animalHistory);
    }
}
