package com.rto.dao.impl;

import com.rto.dao.RegistrationDAO;
import com.rto.model.Registration;
import com.rto.util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {

    @Override
    public void addRegistration(Registration reg) {
        String sql = "INSERT INTO registrations (vehicle_id, registration_date, expiry_date) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, reg.getVehicleId());
            ps.setDate(2, java.sql.Date.valueOf(reg.getRegistrationDate()));
            ps.setDate(3, java.sql.Date.valueOf(reg.getExpiryDate()));

            ps.executeUpdate();
            System.out.println("✅ Registration added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Registration getRegistrationById(int id) {
        String sql = "SELECT * FROM registrations WHERE registration_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Registration(
                        rs.getInt("registration_id"),
                        rs.getInt("vehicle_id"),
                        rs.getDate("registration_date").toLocalDate(),
                        rs.getDate("expiry_date").toLocalDate()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Registration> getAllRegistrations() {
        List<Registration> list = new ArrayList<>();
        String sql = "SELECT * FROM registrations";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Registration(
                        rs.getInt("registration_id"),
                        rs.getInt("vehicle_id"),
                        rs.getDate("registration_date").toLocalDate(),
                        rs.getDate("expiry_date").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateRegistration(Registration reg) {
        String sql = "UPDATE registrations SET vehicle_id=?, registration_date=?, expiry_date=? WHERE registration_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, reg.getVehicleId());
            ps.setDate(2, java.sql.Date.valueOf(reg.getRegistrationDate()));
            ps.setDate(3, java.sql.Date.valueOf(reg.getExpiryDate()));
            ps.setInt(4, reg.getRegistrationId());
            ps.executeUpdate();
            System.out.println("✅ Registration updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRegistration(int id) {
        String sql = "DELETE FROM registrations WHERE registration_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Registration deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
