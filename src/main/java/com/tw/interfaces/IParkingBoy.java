package com.tw.interfaces;

import com.tw.Car;
import com.tw.ParkLot;
import com.tw.ParkSlot;
import com.tw.Receipt;

public interface IParkingBoy {
    public Long getAvailblePark();
    public Receipt parkCarByParkId(Long parkId, Car car);
    public void addParkSlotToParkLot(ParkSlot parkSlot, ParkLot parkLot);
    public void removeParkSlotToParkLot(ParkSlot parkSlot, ParkLot parkLot);
}
