package com.ganeo.appli.zentrip.model;

import com.ganeo.appli.zentrip.utils.DateUtils;

import org.joda.time.LocalDate;

import java.io.Serializable;
import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

public class SynchronizedEntity implements Serializable {

    @PrimaryKey
    @NonNull
    public String id;


    public Long createdDate;

    public Long lastUpdateDate;

    public SynchronizedEntity() {
        this.id = UUID.randomUUID().toString();
        this.createdDate = DateUtils.getLongDate(LocalDate.now());
        this.lastUpdateDate = DateUtils.getLongDate(LocalDate.now());
    }
}
