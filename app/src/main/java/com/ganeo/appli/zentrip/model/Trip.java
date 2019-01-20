package com.ganeo.appli.zentrip.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Booking.class,
        parentColumns = "id",
        childColumns = "bookingId",
        onDelete = CASCADE))
public class Trip extends SynchronizedEntity {

    public String bookingId;

    public Integer evalTrip;
}
