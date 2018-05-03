package com.bithunters;

/**
 * Created by kushan on 1/22/18.
 */

public class Response {
    private String success;
    private String message;

    public Response(String success, String message) {
        this.success = success;
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
