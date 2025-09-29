package com.rto.dao.impl;

import com.rto.dao.FineDAO;
import com.rto.model.Fine;
import com.rto.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FineDAOImpl implements FineDAO {

    @Override
    public void addFine(Fine fine) {
        String sql = "INSERT INTO fines (owner_id, reason, amount, fine_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, fine.getOwnerId());
            ps.setString(2, fine.getReason());
            ps.setDouble(3, fine.getAmount());
            ps.setDate(4, java.sql.Date.valueOf(fine.getFineDate()));
            ps.executeUpdate();
            System.out.println("✅ Fine added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Fine getFineById(int id) {
        String sql = "SELECT * FROM fines WHERE fine_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Fine(
                        rs.getInt("fine_id"),
                        rs.getInt("owner_id"),
                        rs.getString("reason"),
                        rs.getDouble("amount"),
                        rs.getDate("fine_date").toLocalDate()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Fine> getAllFines() {
        List<Fine> list = new ArrayList<>();
        String sql = "SELECT * FROM fines";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Fine(
                        rs.getInt("fine_id"),
                        rs.getInt("owner_id"),
                        rs.getString("reason"),
                        rs.getDouble("amount"),
                        rs.getDate("fine_date").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateFine(Fine fine) {
        String sql = "UPDATE fines SET owner_id=?, reason=?, amount=?, fine_date=? WHERE fine_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, fine.getOwnerId());
            ps.setString(2, fine.getReason());
            ps.setDouble(3, fine.getAmount());
            ps.setDate(4, java.sql.Date.valueOf(fine.getFineDate()));
            ps.setInt(5, fine.getFineId());
            ps.executeUpdate();
            System.out.println("✅ Fine updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFine(int id) {
        String sql = "DELETE FROM fines WHERE fine_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Fine deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Fine> getFinesByOwnerId(int ownerId) {
        List<Fine> list = new ArrayList<>();
        String sql = "SELECT * FROM fines WHERE owner_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ownerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Fine(
                        rs.getInt("fine_id"),
                        rs.getInt("owner_id"),
                        rs.getString("reason"),
                        rs.getDouble("amount"),
                        rs.getDate("fine_date").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
