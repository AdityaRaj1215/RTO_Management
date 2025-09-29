package com.rto.dao;

import com.rto.model.Registration;
import java.util.List;

public interface RegistrationDAO {
    void addRegistration(Registration registration);
    Registration getRegistrationById(int id);
    List<Registration> getAllRegistrations();
    void updateRegistration(Registration registration);
    void deleteRegistration(int id);
}
