package com.rto.service;

import com.rto.dao.RegistrationDAO;
import com.rto.dao.impl.RegistrationDAOImpl;
import com.rto.model.Registration;

import java.util.List;

public class RegistrationService {
    private RegistrationDAO dao = new RegistrationDAOImpl();

    public void addRegistration(Registration reg) { dao.addRegistration(reg); }
    public Registration getRegistrationById(int id) { return dao.getRegistrationById(id); }
    public List<Registration> getAllRegistrations() { return dao.getAllRegistrations(); }
    public void updateRegistration(Registration reg) { dao.updateRegistration(reg); }
    public void deleteRegistration(int id) { dao.deleteRegistration(id); }
}
