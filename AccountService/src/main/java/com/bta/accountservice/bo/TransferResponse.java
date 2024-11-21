package com.bta.accountservice.bo;

public class TransferResponse {

    private String message;
    private String error;

    public TransferResponse() {}

    public TransferResponse(String message, String error) {
        this.message = message;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "TransferResponse{" +
                "message='" + message + '\'' +
                ", error='" + error + '\'' +
                '}';
    }


}
