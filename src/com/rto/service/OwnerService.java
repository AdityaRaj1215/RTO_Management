package com.rto.service;

import com.rto.dao.OwnerDAO;
import com.rto.dao.impl.OwnerDAOImpl;
import com.rto.model.Owner;
import java.util.List;

public class OwnerService {
    private OwnerDAO ownerDAO = new OwnerDAOImpl();

    public void addOwner(Owner owner) { ownerDAO.addOwner(owner); }
    public Owner getOwnerById(int id) { return ownerDAO.getOwnerById(id); }
    public List<Owner> getAllOwners() { return ownerDAO.getAllOwners(); }
    public void updateOwner(Owner owner) { ownerDAO.updateOwner(owner); }
    public void deleteOwner(int id) { ownerDAO.deleteOwner(id); }
}
