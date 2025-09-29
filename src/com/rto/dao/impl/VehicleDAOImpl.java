package com.rto.dao.impl;

import com.rto.dao.VehicleDAO;
import com.rto.model.Vehicle;
import com.rto.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl implements VehicleDAO {

    @Override
    public void addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (reg_no, type, model, owner_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            System.out.println("👉 DEBUG: Inserting with owner_id = " + vehicle.getOwnerId());

            ps.setString(1, vehicle.getRegNo());
            ps.setString(2, vehicle.getType());
            ps.setString(3, vehicle.getModel());
            ps.setInt(4, vehicle.getOwnerId());
            ps.executeUpdate();
            System.out.println("✅ Vehicle added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Vehicle getVehicleById(int id) {
        String sql = "SELECT * FROM vehicles WHERE vehicle_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Vehicle(
                        rs.getInt("vehicle_id"),
                        rs.getString("reg_no"),
                        rs.getString("type"),
                        rs.getString("model"),
                        rs.getInt("owner_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> list = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Vehicle(
                        rs.getInt("vehicle_id"),
                        rs.getString("reg_no"),
                        rs.getString("type"),
                        rs.getString("model"),
                        rs.getInt("owner_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        String sql = "UPDATE vehicles SET reg_no=?, type=?, model=?, owner_id=? WHERE vehicle_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, vehicle.getRegNo());
            ps.setString(2, vehicle.getType());
            ps.setString(3, vehicle.getModel());
            ps.setInt(4, vehicle.getOwnerId());
            ps.setInt(5, vehicle.getVehicleId());
            ps.executeUpdate();
            System.out.println("✅ Vehicle updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVehicle(int id) {
        String sql = "DELETE FROM vehicles WHERE vehicle_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Vehicle deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
