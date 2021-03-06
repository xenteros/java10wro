package com.github.xenteros.repository;

import com.github.xenteros.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    Set<Address> findAllBy();
    void deleteByUuid(String uuid);
    Set<Address> findAllByCityAndState(String city, String state);
    Address findOneByUuid(String uuid);
}
