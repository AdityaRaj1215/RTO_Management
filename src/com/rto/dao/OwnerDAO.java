package com.rto.dao;

import com.rto.model.Owner;
import java.util.List;

public interface OwnerDAO {
    void addOwner(Owner owner);
    Owner getOwnerById(int id);
    List<Owner> getAllOwners();
    void updateOwner(Owner owner);
    void deleteOwner(int id);
}
