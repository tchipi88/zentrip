package com.ganeo.appli.zentrip.dto.password;

import java.io.Serializable;

/**
 * Created by tchipnangngansopa on 26/12/2017.
 */

public class KeyAndPasswordVM implements Serializable {

    private String key;

    private String newPassword;

    public KeyAndPasswordVM(String key, String newPassword) {
        this.key = key;
        this.newPassword = newPassword;
    }

    public KeyAndPasswordVM() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
