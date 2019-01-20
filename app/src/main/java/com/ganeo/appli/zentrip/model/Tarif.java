package com.ganeo.appli.zentrip.model;


import androidx.room.Entity;
import androidx.room.ForeignKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = {@ForeignKey(entity = Town.class,
        parentColumns = "id",
        childColumns = "townFrom",
        onDelete = CASCADE), @ForeignKey(entity = Town.class,
        parentColumns = "id",
        childColumns = "townTo",
        onDelete = CASCADE), @ForeignKey(entity = Car.class,
        parentColumns = "id",
        childColumns = "carId",
        onDelete = CASCADE)})
public class Tarif extends SynchronizedEntity {

    public String townFrom;

    public String townTo;


    public Integer price;

    public String carId;


}
