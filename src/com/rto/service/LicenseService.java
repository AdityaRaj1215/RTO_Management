package com.rto.service;

import com.rto.dao.LicenseDAO;
import com.rto.dao.impl.LicenseDAOImpl;
import com.rto.model.License;
import java.util.List;

public class LicenseService {
    private LicenseDAO dao = new LicenseDAOImpl();

    public void addLicense(License license) { dao.addLicense(license); }
    public License getLicenseById(int id) { return dao.getLicenseById(id); }
    public List<License> getAllLicenses() { return dao.getAllLicenses(); }
    public void updateLicense(License license) { dao.updateLicense(license); }
    public void deleteLicense(int id) { dao.deleteLicense(id); }
}
