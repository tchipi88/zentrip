package com.ganeo.appli.zentrip.dto.retrofit;

import com.ganeo.appli.zentrip.dto.User;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by tchipnangngansopa on 16/12/2017.
 */

public class AccessToken implements Serializable {

    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("expires_in")
    private long expiresIn;
    private long expiredAfterMilli = 0;
    @SerializedName("refresh_token")
    private String refreshToken;

    private User user;
    // region Fields

    // endregion
// region Constructors
    public AccessToken(String tokenType, String accessToken) {
        this.tokenType = tokenType;
        this.accessToken = accessToken;
    }
    // endregion

    // region Getters
    public String getTokenType() {
        // OAuth requires uppercase Authorization HTTP header value for token type
        if (!Character.isUpperCase(tokenType.charAt(0))) {
            tokenType = Character.toString(tokenType.charAt(0)).toUpperCase() + tokenType.substring(1);
        }

        return tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }
    // endregion


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

