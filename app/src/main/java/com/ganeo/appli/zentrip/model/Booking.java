package com.ganeo.appli.zentrip.model;

import com.ganeo.appli.zentrip.model.enumeration.StatusBooking;
import com.ganeo.appli.zentrip.utils.DateUtils;

import org.joda.time.LocalDate;

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
        onDelete = CASCADE)
}, indices = {@Index("driverId"), @Index("carId")})
public class Booking extends SynchronizedEntity {

    public StatusBooking status;

    public String dateDebut;

    public String dateFin;

    public String carId;

    public String driverId;

    public String townFrom;

    public String townTo;

    public Booking(String dateDebut, String dateFin,  String townFrom, String townTo,String carId, String driverId) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.carId = carId;
        this.driverId = driverId;
        this.townFrom = townFrom;
        this.townTo = townTo;
    }

    public Booking() {

    }

    public static Booking[] populateData() {

        return new Booking[]{
                new Booking(DateUtils.getStringDate(LocalDate.now()), DateUtils.getStringDate(LocalDate.now().plusDays(5)), "Yaounde","Douala", "Mercedes Benz","Jean Paul"),
                new Booking(DateUtils.getStringDate(LocalDate.now().plusMonths(1)), DateUtils.getStringDate(LocalDate.now().plusMonths(1).plusDays(2)), "Yaounde","Douala", "Mercedes Benz","Jean Paul"),
                new Booking(DateUtils.getStringDate(LocalDate.now().plusWeeks(2)), DateUtils.getStringDate(LocalDate.now().plusWeeks(2).plusDays(2)), "Yaounde","Douala", "Mercedes Benz","Jean Paul"),


        };
    }

}
