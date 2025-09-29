package com.rto.service;

import com.rto.dao.VehicleDAO;
import com.rto.dao.impl.VehicleDAOImpl;
import com.rto.model.Vehicle;

import java.util.List;

public class VehicleService {
    private final VehicleDAO dao = new VehicleDAOImpl();

    public void addVehicle(Vehicle vehicle) {
        dao.addVehicle(vehicle);
    }

    public Vehicle getVehicleById(int id) {
        return dao.getVehicleById(id);
    }

    public List<Vehicle> getAllVehicles() {
        return dao.getAllVehicles();
    }

    public void updateVehicle(Vehicle vehicle) {
        dao.updateVehicle(vehicle);
    }

    public void deleteVehicle(int id) {
        dao.deleteVehicle(id);
    }
}
