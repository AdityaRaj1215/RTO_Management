package com.rto.dao.impl;

import com.rto.dao.OwnerDAO;
import com.rto.model.Owner;
import com.rto.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OwnerDAOImpl implements OwnerDAO {

    @Override
    public void addOwner(Owner owner) {
        String sql = "INSERT INTO owners (name, address, phone) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, owner.getName());
            ps.setString(2, owner.getAddress());
            ps.setString(3, owner.getPhone());
            ps.executeUpdate();
            System.out.println("✅ Owner added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Owner getOwnerById(int id) {
        String sql = "SELECT * FROM owners WHERE owner_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Owner(
                        rs.getInt("owner_id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Owner> getAllOwners() {
        List<Owner> list = new ArrayList<>();
        String sql = "SELECT * FROM owners";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Owner(
                        rs.getInt("owner_id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateOwner(Owner owner) {
        String sql = "UPDATE owners SET name=?, address=?, phone=? WHERE owner_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, owner.getName());
            ps.setString(2, owner.getAddress());
            ps.setString(3, owner.getPhone());
            ps.setInt(4, owner.getOwnerId());
            ps.executeUpdate();
            System.out.println("✅ Owner updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOwner(int id) {
        String sql = "DELETE FROM owners WHERE owner_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Owner deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
