package org.doit.service;

import org.doit.config.CoreConfig;
import org.doit.config.PersistenceConfig;
import org.doit.model.Address;
import org.doit.model.Organization;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.doit.OrganizationTestData.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CoreConfig.class, PersistenceConfig.class})
@Sql(scripts = "classpath:populateDB4tests.sql", config = @SqlConfig(encoding = "UTF-8"))
public class AddressServiceTest {

    @Autowired
    protected AddressService service;

    @Test
    void getWithOrganization() {
        List<Address> actual = service.getWithOrganization(ORGANIZATION_1_ID);
        assertThat(actual).usingElementComparatorOnFields("organizationId").isEqualTo(List.of(ADDRESS_1_ORGANIZATION_1, ADDRESS_2_ORGANIZATION_1));
        assertEquals(ORGANIZATION_1, actual.get(0).getOrganization());
    }
}
