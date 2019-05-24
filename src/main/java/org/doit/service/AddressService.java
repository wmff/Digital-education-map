package org.doit.service;

import org.doit.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> getWithOrganization(Long organizationId);
}
