package com.tw.exceptions;

public class ParkLotNotFoundException extends DomainException {
    public ParkLotNotFoundException(String message) {
        super(message);
    }
}
