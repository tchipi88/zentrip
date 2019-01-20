package com.ganeo.appli.zentrip.model;

import androidx.room.Entity;

@Entity
public class Car extends SynchronizedEntity {

    public String marque;

    public String model;

    public Integer nbrePlaces;

    public boolean aircon;

    public Car(String marque, String model, Integer nbrePlaces, boolean aircon) {
        super();
        this.marque = marque;
        this.model = model;
        this.nbrePlaces = nbrePlaces;
        this.aircon = aircon;
    }

    public static Car[] populateData() {

        return new Car[]{
                new Car("TOYOTA", "CAMRI", 5, false),
                new Car("TOYOTA", "LEXUS", 5, true),
                new Car("LEXUS", "IS", 5, false),
                new Car("LEXUS", "LS", 5, false),
                new Car("TOYOTA", "CAMRI", 5, false),
                new Car("CITROEN", "C3", 5, false),
                new Car("CITROEN", "Q4", 5, false)

        };
    }

}
