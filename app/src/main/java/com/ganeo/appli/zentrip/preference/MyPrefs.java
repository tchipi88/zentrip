package com.ganeo.appli.zentrip.preference;

import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Interface permet d'utiliser les SharedPreferences de manière Typesafe, à travers <i>Android Annotations</i>, à la place d'utiliser des chaînes de caractères.
 */
@SharedPref(value = SharedPref.Scope.APPLICATION_DEFAULT)
public interface MyPrefs {


    String token();

    String tokenType();

    String firebaseToken();


    String currentUserEmail();

    String currentUserTelephone();

    String currentUserTown();

    String currentUserDistrict();

    String currentUserResetDate();

    String currentUserProfil();


    String currentUserName();

    String currentUser();


    boolean isLogged();


    boolean firstLaunch();


}