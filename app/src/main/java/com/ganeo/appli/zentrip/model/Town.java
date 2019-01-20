package com.ganeo.appli.zentrip.model;

import com.ganeo.appli.zentrip.model.enumeration.Region;

import androidx.room.Entity;

@Entity
public class Town extends SynchronizedEntity {

    public String nom;

    public Region region;

    public Town(String id, String nom, Region region) {
        super();
        this.id = id;
        this.nom = nom;
        this.region = region;
    }

    public static Town[] populateData() {

        return new Town[]{
                new Town("YDE", "Yaounde", Region.Centre),
                new Town("DLA", "Douala", Region.Littoral),
                new Town("BAF", "Bafoussam", Region.Ouest)
        };
    }


}
