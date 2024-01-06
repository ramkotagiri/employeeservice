package com.kotagiri.employeeservice.crud;

import com.kotagiri.employeeservice.entity.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {
    @Query("select a from Address a join Employee e on a.pk=e.address.pk where e.id=?1")
    Address getAddressByEmployeeID(String id);
}
