package com.ganeo.appli.zentrip.dto.retrofit;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by tchipi on 7/22/18.
 */

public class TokenError implements Serializable {

    private String error;

    @SerializedName("error_description")
    private String errorDescription;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
