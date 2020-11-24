package com.mobile.academy.trainingspringdemo.evenimente.model;

public class ErrorObject {

private String message;
private int errorCode;

    public ErrorObject(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public ErrorObject() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "ErrorObject{" +
                "message='" + message + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}



