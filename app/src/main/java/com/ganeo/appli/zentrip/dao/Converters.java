package com.ganeo.appli.zentrip.dao;


import com.ganeo.appli.zentrip.model.enumeration.Gender;
import com.ganeo.appli.zentrip.model.enumeration.Profil;
import com.ganeo.appli.zentrip.model.enumeration.Region;
import com.ganeo.appli.zentrip.model.enumeration.StatusBooking;
import com.ganeo.appli.zentrip.model.enumeration.StatutMarital;

import androidx.room.TypeConverter;

public class Converters {

    @TypeConverter
    public static String fromProfil(Profil profil) {
        return profil == null ? null : profil.name();
    }

    @TypeConverter
    public static Profil toProfil(String profil) {
        return profil == null ? null : Profil.valueOf(profil);
    }


    @TypeConverter
    public static String fromRegion(Region region) {
        return region == null ? null : region.name();
    }

    @TypeConverter
    public static Region toRegion(String region) {
        return region == null ? null : Region.valueOf(region);
    }

    @TypeConverter
    public static String fromStatutMarital(StatutMarital statutMarital) {
        return statutMarital == null ? null : statutMarital.name();
    }

    @TypeConverter
    public static StatutMarital toStatutMarital(String statutMarital) {
        return statutMarital == null ? null : StatutMarital.valueOf(statutMarital);
    }


    @TypeConverter
    public static String fromStatusBooking(StatusBooking statusBooking) {
        return statusBooking == null ? null : statusBooking.name();
    }

    @TypeConverter
    public static StatusBooking toStatusBooking(String statusBooking) {
        return statusBooking == null ? null : StatusBooking.valueOf(statusBooking);
    }

    @TypeConverter
    public static String fromGender(Gender gender) {
        return gender == null ? null : gender.name();
    }

    @TypeConverter
    public static Gender toGender(String gender) {
        return gender == null ? null : Gender.valueOf(gender);
    }
}
