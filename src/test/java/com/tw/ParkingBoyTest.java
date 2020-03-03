package com.tw;

import com.tw.exceptions.ParkLotCarFullException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ParkingBoyTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void should_get_parklot_when_parklot_is_not_full() {
        ParkingBoy parkingBoy = new ParkingBoy();
        String platNumber = "1234";
        Car car = new Car(platNumber);
        try {
            Long pId = parkingBoy.getAvailblePark();
            Receipt receipt = parkingBoy.parkCarByParkId(pId, car);
            assertEquals(platNumber, receipt.plateNumber);
        } catch (ParkLotCarFullException e) {
        }
    }

    @Test
    public void should_cannot_park_when_parklot_is_all_full() {
        ParkingBoy parkingBoy = new ParkingBoy();
        for (int i = 0; i < ParkLotConstant.MAX_PARKSLOT_NUMBER * 2; i++) {
            Car car = new Car(String.valueOf(i));
            if (i < ParkLotConstant.MAX_PARKSLOT_NUMBER) {
                parkingBoy.parkCarByParkId(1L, car);
            } else {
                parkingBoy.parkCarByParkId(2L, car);
            }
        }
        Car car = new Car("1234");
        exceptionRule.expect(ParkLotCarFullException.class);
        parkingBoy.parkCarByParkId(1L, car);
    }

    @Test
    public void should_cannot_park_when_parklot_is_full() {
        ParkingBoy parkingBoy = new ParkingBoy();
        for (int i = 0; i < ParkLotConstant.MAX_PARKSLOT_NUMBER; i++) {
            Car car = new Car(String.valueOf(i));
            parkingBoy.parkCarByParkId(1L, car);
        }
        Car car = new Car("1234");
        exceptionRule.expect(ParkLotCarFullException.class);
        parkingBoy.parkCarByParkId(1L, car);
    }

    @Test
    public void should_get_no_parklot_when_parklot_is_all_full() {
        ParkingBoy parkingBoy = new ParkingBoy();
        for (int i = 0; i < ParkLotConstant.MAX_PARKSLOT_NUMBER * 2; i++) {
            Car car = new Car(String.valueOf(i));
            if (i < ParkLotConstant.MAX_PARKSLOT_NUMBER) {
                parkingBoy.parkCarByParkId(1L, car);
            } else {
                parkingBoy.parkCarByParkId(2L, car);
            }
        }
        exceptionRule.expect(ParkLotCarFullException.class);
        parkingBoy.getAvailblePark();
    }

}
