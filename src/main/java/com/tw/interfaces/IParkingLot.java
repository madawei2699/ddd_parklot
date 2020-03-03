package com.tw.interfaces;

import com.tw.Car;
import com.tw.Receipt;

public interface IParkingLot {
    public Boolean isReceiptValid(Receipt receipt);
    public Car getCarByReceipt(Receipt receipt);
    public Receipt parkCar(Car car);
}
