package com.rto.dao.impl;

import com.rto.dao.LicenseDAO;
import com.rto.model.License;
import com.rto.util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LicenseDAOImpl implements LicenseDAO {

    @Override
    public void addLicense(License license) {
        String sql = "INSERT INTO licenses (license_number, owner_id, type, issue_date, expiry_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, license.getLicenseNumber());
            ps.setInt(2, license.getOwnerId());
            ps.setString(3, license.getType());
            ps.setDate(4, java.sql.Date.valueOf(license.getIssueDate()));
            ps.setDate(5, java.sql.Date.valueOf(license.getExpiryDate()));

            ps.executeUpdate();
            System.out.println("✅ License added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public License getLicenseById(int id) {
        String sql = "SELECT * FROM licenses WHERE license_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new License(
                        rs.getInt("license_id"),
                        rs.getString("license_number"),
                        rs.getInt("owner_id"),
                        rs.getString("type"),
                        rs.getDate("issue_date").toLocalDate(),
                        rs.getDate("expiry_date").toLocalDate()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<License> getAllLicenses() {
        List<License> list = new ArrayList<>();
        String sql = "SELECT * FROM licenses";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new License(
                        rs.getInt("license_id"),
                        rs.getString("license_number"),
                        rs.getInt("owner_id"),
                        rs.getString("type"),
                        rs.getDate("issue_date").toLocalDate(),
                        rs.getDate("expiry_date").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateLicense(License license) {
        String sql = "UPDATE licenses SET license_number=?, owner_id=?, type=?, issue_date=?, expiry_date=? WHERE license_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, license.getLicenseNumber());
            ps.setInt(2, license.getOwnerId());
            ps.setString(3, license.getType());
            ps.setDate(4, java.sql.Date.valueOf(license.getIssueDate()));
            ps.setDate(5, java.sql.Date.valueOf(license.getExpiryDate()));
            ps.setInt(6, license.getLicenseId());
            ps.executeUpdate();
            System.out.println("✅ License updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLicense(int id) {
        String sql = "DELETE FROM licenses WHERE license_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ License deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
