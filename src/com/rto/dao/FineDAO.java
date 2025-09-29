package com.rto.dao;

import com.rto.model.Fine;
import java.util.List;

public interface FineDAO {
    void addFine(Fine fine);
    Fine getFineById(int id);
    List<Fine> getAllFines();
    void updateFine(Fine fine);
    void deleteFine(int id);
    List<Fine> getFinesByOwnerId(int ownerId);
}
