package com.ganeo.appli.zentrip.dto;


import com.ganeo.appli.zentrip.model.SynchronizedEntity;
import com.ganeo.appli.zentrip.model.enumeration.Gender;
import com.ganeo.appli.zentrip.model.enumeration.Profil;

/**
 * Created by tchipnangngansopa on 28/06/2017.
 */
public class User extends SynchronizedEntity {

    public Gender gender;
    private String email;
    private String nom;
    private String prenom;
    private Profil profil;
    private String telephone;

    private boolean activated = false;
    private String firebaseToken;
    private String resetDate;

    public User() {
    }


    public User(String email, String nom, Profil authorities, String telephone) {
        this.email = email;
        this.nom = nom;
        this.profil = authorities;
        this.telephone = telephone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public String getFirebaseToken() {
        return firebaseToken;
    }

    public void setFirebaseToken(String firebaseToken) {
        this.firebaseToken = firebaseToken;
    }

    public String getResetDate() {
        return resetDate;
    }

    public void setResetDate(String resetDate) {
        this.resetDate = resetDate;
    }
}
