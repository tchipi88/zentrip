package com.ganeo.appli.zentrip.model;

import com.ganeo.appli.zentrip.model.enumeration.StatusBooking;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = {@ForeignKey(entity = Driver.class,
        parentColumns = "id",
        childColumns = "driverId",
        onDelete = CASCADE), @ForeignKey(entity = Car.class,
        parentColumns = "id",
        childColumns = "carId",
        onDelete = CASCADE), @ForeignKey(entity = Town.class,
        parentColumns = "id",
        childColumns = "townTo",
        onDelete = CASCADE), @ForeignKey(entity = Car.class,
        parentColumns = "id",
        childColumns = "carId",
        onDelete = CASCADE)
}, indices = {@Index("driverId"), @Index("carId"), @Index("townFrom"), @Index("townTo")})
public class Booking extends SynchronizedEntity {

    public StatusBooking status;

    public String dateDebut;

    public String dateFin;

    public String carId;

    public String driverId;

    public String townFrom;

    public String townTo;

}
