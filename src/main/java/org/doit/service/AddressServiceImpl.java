package org.doit.service;

import org.doit.model.Address;
import org.doit.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AddressServiceImpl implements AddressService{

    private final AddressRepository repository;

    @Autowired
    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Address> getWithOrganization(Long organizationId) {
        return repository.getWithOrganization(organizationId);
    }
}
