package com.tw;

import java.util.Objects;

public class ParkSlot {

    Long parkLotId;
    Integer parkSlotNumber;

    public ParkSlot(Long parkLotId, Integer parkSlotNumber) {
        this.parkLotId = parkLotId;
        this.parkSlotNumber = parkSlotNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkSlot parkSlot = (ParkSlot) o;
        return parkLotId.equals(parkSlot.parkLotId) &&
                parkSlotNumber.equals(parkSlot.parkSlotNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkLotId, parkSlotNumber);
    }
}
