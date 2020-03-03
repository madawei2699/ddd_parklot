package com.tw;

import com.tw.exceptions.CarNotFoundException;
import com.tw.exceptions.ParkLotCarFullException;
import com.tw.interfaces.IParkingLot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLot implements IParkingLot {

    private Long id;
    private List<Car> cars;
    private List<Receipt> receipts;

    public ParkingLot(Long id) {
        this.id = id;
        this.cars = new ArrayList<>();
        this.receipts = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    public Boolean isReceiptValid(final Receipt receipt) {
        List<Receipt> rs = this.receipts.stream()
                .filter(r -> r.equals(receipt))
                .collect(Collectors.toList());
        return !rs.isEmpty();
    }

    public Car getCarByReceipt(Receipt receipt) {
        String plateNumber = receipt.plateNumber;
        List<Car> cars = this.cars.stream().filter(car -> car.plateNumber.equals(plateNumber))
                .collect(Collectors.toList());
        if (cars.isEmpty()) {
            throw new CarNotFoundException(String.format("Error code is %d", 1000));
        }
        this.cars.removeAll(cars);
        this.receipts.remove(receipt);
        return cars.get(0);
    }

    public Receipt parkCar(Car car) {
        Receipt receipt = new Receipt(car.plateNumber, new Date());
        if (this.cars.size() >= ParkLotConstant.MAX_PARKSLOT_NUMBER) {
            throw new ParkLotCarFullException(String.format("ParkLot %d is full, please use another to park", this.id));
        }
        this.cars.add(car);
        this.receipts.add(receipt);
        return receipt;
    }
}
