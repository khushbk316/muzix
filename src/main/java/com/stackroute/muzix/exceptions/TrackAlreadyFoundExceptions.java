package com.stackroute.muzix.exceptions;

public class TrackAlreadyFoundExceptions extends Exception {


    private  String message;
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TrackAlreadyFoundExceptions(String message) {
        super(message);
        this.message = message;
    }

    public TrackAlreadyFoundExceptions() {
    }
}
