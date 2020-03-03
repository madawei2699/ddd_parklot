package com.tw;

import com.tw.exceptions.CarNotFoundException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ParkingLotTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void should_receipt_valid_when_parkingLot_has_receipt() {
        ParkingLot parkingLot = new ParkingLot(1L);
        Car car = new Car("1234");
        Receipt receipt = parkingLot.parkCar(car);
        assertEquals(true, parkingLot.isReceiptValid(receipt));
    }

    @Test
    public void should_get_car_when_give_valid_receipt() {
        ParkingLot parkingLot = new ParkingLot(1L);
        Car car = new Car("1234");
        Receipt receipt = parkingLot.parkCar(car);
        assertEquals(car, parkingLot.getCarByReceipt(receipt));
    }

    @Test
    public void should_get_no_car_when_give_invalid_receipt() {
        ParkingLot parkingLot = new ParkingLot(1L);
        Car car = new Car("1234");
        parkingLot.parkCar(car);
        Receipt invalidReceipt = new Receipt("4321", new Date());
        exceptionRule.expect(CarNotFoundException.class);
        parkingLot.getCarByReceipt(invalidReceipt);
    }
}
