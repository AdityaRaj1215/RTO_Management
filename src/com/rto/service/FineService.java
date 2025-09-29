package com.rto.service;

import com.rto.dao.FineDAO;
import com.rto.dao.impl.FineDAOImpl;
import com.rto.model.Fine;

import java.util.List;

public class FineService {
    private final FineDAO dao = new FineDAOImpl();

    public void addFine(Fine fine) { dao.addFine(fine); }
    public Fine getFineById(int id) { return dao.getFineById(id); }
    public List<Fine> getAllFines() { return dao.getAllFines(); }
    public void updateFine(Fine fine) { dao.updateFine(fine); }
    public void deleteFine(int id) { dao.deleteFine(id); }
    public List<Fine> getFinesByOwnerId(int ownerId) { return dao.getFinesByOwnerId(ownerId); }
}
