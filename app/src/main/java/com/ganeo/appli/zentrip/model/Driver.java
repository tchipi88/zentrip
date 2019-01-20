package com.ganeo.appli.zentrip.model;


import com.ganeo.appli.zentrip.dto.User;
import com.ganeo.appli.zentrip.model.enumeration.Profil;
import com.ganeo.appli.zentrip.model.enumeration.StatutMarital;

import androidx.room.Entity;


@Entity
public class Driver extends User {


    public StatutMarital statutMarital;

    public String birthday;

    public String town;
    public String district;

    public Integer evaluation;

    public String bestTrajet;

    public String experience;

    public String profession;

    public Driver(String email, String nom, String telephone, StatutMarital statutMarital, String birthday, String town, Integer evaluation, String profession) {
        super(email, nom, Profil.ROLE_DRIVER, telephone);
        this.statutMarital = statutMarital;
        this.birthday = birthday;
        this.town = town;
        this.evaluation = evaluation;
        this.profession = profession;
    }

    public static Driver[] populateData() {

        return new Driver[]{
                new Driver("test@gg.com", "Jean Paul", "65648999", StatutMarital.CELIBATAIRE, "10/10/1988", "Douala", 4, "chauffeur Taxi"),
                new Driver("test@gg.com", "Ulrich Tamno", "65648999", StatutMarital.CELIBATAIRE, "10/10/1956", "Douala", 3, "chauffeur Taxi"),
                new Driver("test@gg.com", "Dieudonne Mnola", "65648999", StatutMarital.MARIE, "10/10/1976", "Douala", 1, "chauffeur Taxi"),
                new Driver("test@gg.com", "Arthur Ngansop", "65648999", StatutMarital.CELIBATAIRE, "10/10/1966", "Douala", 4, "chauffeur Taxi"),
                new Driver("test@gg.com", "Boris Tiomos", "65648999", StatutMarital.MARIE, "10/10/1996", "Yaounde", 4, "chauffeur Taxi")
        };
    }
}
