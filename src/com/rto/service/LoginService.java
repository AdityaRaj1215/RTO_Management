package com.rto.service;

import com.rto.util.DBConnection;
import java.sql.*;

public class LoginService {
    public String login(String username, String password) {
        String role = null;
        String sql = "SELECT role FROM users WHERE username=? AND password=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                role = rs.getString("role"); // returns ADMIN or USER
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }
}
