package com.tw;

import java.util.Date;
import java.util.Objects;

public class Receipt {
    String plateNumber;
    Date parkingTime;

    public Receipt(String plateNumber, Date parkingTime) {
        this.plateNumber = plateNumber;
        this.parkingTime = parkingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return plateNumber.equals(receipt.plateNumber) &&
                parkingTime.equals(receipt.parkingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, parkingTime);
    }
}
