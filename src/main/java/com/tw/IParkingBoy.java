package com.tw;

public interface IParkingBoy {
    public Long getAvailblePark();
    public Receipt parkCarByParkId(Long parkId, Car car);
    public void addParkSlotToParkLot(ParkSlot parkSlot, ParkLot parkLot);
    public void removeParkSlotToParkLot(ParkSlot parkSlot, ParkLot parkLot);
}
