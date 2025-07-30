package com.kce.icecream_service.utility;

public class FlavourNotFoundException extends RuntimeException {

    public FlavourNotFoundException(String data) {
        super(data);
    }
    @Override
    public String toString() {
        return "FlavourNotFoundException{message='" + getMessage() + "'}";
    }
}
