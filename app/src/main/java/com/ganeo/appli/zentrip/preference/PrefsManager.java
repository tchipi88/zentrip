package com.ganeo.appli.zentrip.preference;

import com.ganeo.appli.zentrip.dto.User;
import com.ganeo.appli.zentrip.dto.retrofit.AccessToken;
import com.google.gson.Gson;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.sharedpreferences.Pref;


/**
 * Manager pour les intéractions avec les préférences de l'application.
 */
@EBean
public class PrefsManager {


    @Pref
    protected MyPrefs_ prefs;


    public String getToken() {
        return prefs.token().get();
    }

    public void setToken(AccessToken accessToken) {


        prefs.edit().token().put(accessToken.getAccessToken()).apply();
        prefs.edit().tokenType().put(accessToken.getTokenType()).apply();

        setLogged(true);

        User user = accessToken.getUser();
        setCurrentUser(user);

    }

    public String getTokenType() {
        return prefs.tokenType().get();
    }

    public User getCurrentUser() {
        Gson gson = new Gson();
        String json = prefs.currentUser().get();
        return gson.fromJson(json, User.class);
    }


    public void setCurrentUser(User user) {
        Gson gson = new Gson();
        prefs.edit().currentUser().put(gson.toJson(user)).apply();
        if (user != null) {
            setFirebaseToken(user.getFirebaseToken());
            setCurrentUserName(user.getPrenom() != null ? user.getPrenom().concat(" " + user.getNom()) : user.getNom());
            setCurrentUserEmail(user.getEmail());
            setCurrentUserProfil(user.getProfil().name());
        } else {
            setFirebaseToken(null);
            setCurrentUserName(null);
            setCurrentUserEmail(null);
            setCurrentUserProfil(null);
        }
    }

    public String getFirebaseToken() {
        return prefs.firebaseToken().get();
    }


    public void setFirebaseToken(String token) {
        prefs.edit().firebaseToken().put(token).apply();
    }

    public String getCurrentUserEmail() {
        return prefs.currentUserEmail().get();
    }


    public void setCurrentUserEmail(String email) {
        prefs.edit().currentUserEmail().put(email).apply();
    }

    public String getCurrentUserName() {
        return prefs.currentUserName().get();
    }


    public void setCurrentUserName(String name) {
        prefs.edit().currentUserName().put(name).apply();
    }

    public String getCurrentUserProfil() {
        return prefs.currentUserProfil().get();
    }


    public void setCurrentUserProfil(String profil) {
        prefs.edit().currentUserProfil().put(profil).apply();
    }


    public boolean isLogged() {
        return prefs.isLogged().get();
    }


    public void setLogged(boolean isLogged) {
        prefs.edit().isLogged().put(isLogged).apply();
    }

    public boolean isFirstLaunch() {
        return prefs.firstLaunch().getOr(true);
    }


    public void setFirstLaunch(boolean firstLaunch) {
        prefs.edit().firstLaunch().put(firstLaunch).apply();
    }


    public void clearSessionPrefs() {
        prefs.clear();
    }


}
