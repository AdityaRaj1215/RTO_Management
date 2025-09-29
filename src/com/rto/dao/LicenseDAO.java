package com.rto.dao;

import com.rto.model.License;
import java.util.List;

public interface LicenseDAO {
    void addLicense(License license);
    License getLicenseById(int id);
    List<License> getAllLicenses();
    void updateLicense(License license);
    void deleteLicense(int id);
}
