package com.tw.exceptions;

public class CarNotFoundException extends DomainException {
    public CarNotFoundException(String message) {
        super(message);
    }
}
