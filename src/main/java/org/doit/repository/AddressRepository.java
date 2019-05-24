package org.doit.repository;

import org.doit.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("SELECT a FROM Address a LEFT JOIN FETCH a.organization WHERE a.organizationId=?1")
    List<Address> getWithOrganization(Long organizationId);
}
