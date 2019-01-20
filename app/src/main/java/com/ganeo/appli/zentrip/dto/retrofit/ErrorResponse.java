package com.ganeo.appli.zentrip.dto.retrofit;

/**
 * Created by tchipnangngansopa on 17/12/2017.
 */

public class ErrorResponse {

    private int statusCode;
    private String message;

    public ErrorResponse() {


    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
