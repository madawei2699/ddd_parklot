package com.tw;

import com.tw.exceptions.CarNotFoundException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ParkLotTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void should_receipt_valid_when_parkingLot_has_receipt() {
        ParkLot parkLot = new ParkLot(1L);
        Car car = new Car("1234");
        Receipt receipt = parkLot.parkCar(car);
        assertEquals(true, parkLot.isReceiptValid(receipt));
    }

    @Test
    public void should_get_car_when_give_valid_receipt() {
        ParkLot parkLot = new ParkLot(1L);
        Car car = new Car("1234");
        Receipt receipt = parkLot.parkCar(car);
        assertEquals(car, parkLot.getCarByReceipt(receipt));
    }

    @Test
    public void should_get_no_car_when_give_invalid_receipt() {
        ParkLot parkLot = new ParkLot(1L);
        Car car = new Car("1234");
        parkLot.parkCar(car);
        Receipt invalidReceipt = new Receipt("4321", new Date());
        exceptionRule.expect(CarNotFoundException.class);
        parkLot.getCarByReceipt(invalidReceipt);
    }
}
