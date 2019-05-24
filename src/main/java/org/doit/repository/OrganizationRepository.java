package org.doit.repository;

import org.doit.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    @Query("SELECT o FROM Organization o LEFT JOIN FETCH o.addresses WHERE o.id=:id")
    Organization getWithAddresses(@Param("id") Long id);
}
