package com.tw;

import com.tw.exceptions.ParkLotCarFullException;
import com.tw.exceptions.ParkLotNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingBoy implements IParkingBoy {

    private List<ParkLot> parkLots;

    public ParkingBoy() {
        initParking();
    }

    private void initParking() {
        ParkLot parkLot1 = new ParkLot(1L);
        ParkLot parkLot2 = new ParkLot(2L);
        this.parkLots = new ArrayList<>();
        this.parkLots.add(parkLot1);
        this.parkLots.add(parkLot2);
    }

    @Override
    public Long getAvailblePark() {
        for (ParkLot parkLot: this.parkLots) {
            if (parkLot.isParkLotAvailable()) {
                return parkLot.getId();
            }
        }
        throw new ParkLotCarFullException("All parkLot is full!");
    }

    public List<ParkLot> getParkLots() {
        return parkLots;
    }

    @Override
    public Receipt parkCarByParkId(Long parkId, Car car) {
        Optional<ParkLot> parkLot = parkLots.stream().
                filter(pl -> pl.getId().equals(parkId)).findFirst();
        if (!parkLot.isPresent()) {
            throw new ParkLotNotFoundException("The parkLot id is error!");
        }
        if (!parkLot.get().isParkLotAvailable()) {
            throw new ParkLotCarFullException(String.format("ParkLot %d is full!", parkId));
        }
        return parkLot.get().parkCar(car);
    }

    @Override
    public void addParkSlotToParkLot(ParkSlot parkSlot, ParkLot parkLot) {
        // TODO: need impl
    }

    @Override
    public void removeParkSlotToParkLot(ParkSlot parkSlot, ParkLot parkLot) {
        // TODO: need impl
    }
}
