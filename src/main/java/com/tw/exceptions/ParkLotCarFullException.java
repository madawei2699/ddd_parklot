package com.tw.exceptions;

public class ParkLotCarFullException extends DomainException {
    public ParkLotCarFullException(String message) {
        super(message);
    }
}
