package com.realestate.re.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.re.helper.ResourceNotFoundException;
import com.realestate.re.model.re.Address;
import com.realestate.re.repo.AddressRepository;
import com.realestate.re.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address addAddress(Address address) {
        
        return this.addressRepository.save(address);
    }

    @Override
    public Address getAddress(Long aId) {
        Optional<Address> address = this.addressRepository.findById(aId);
        if (address.isPresent()) {
            return address.get();
        } else {
            throw new ResourceNotFoundException("Address not found");
        }

    }

    @Override
    public Address updateAddress(Address address) {
        Address address1 = new Address();
        address1.setaId(address.getaId());
        address1.setProperty(address.getProperty());
        address1.setaArea(address.getaArea());
        address1.setaCity(address.getaCity());
        address1.setaLandmark(address.getaLandmark());
        address1.setaPincode(address.getaPincode());
        address1.setaState(address.getaState());
        return this.addressRepository.save(address1);




    }

    @Override
    public void deleteAddress(Long aId) {
        Address address = new Address();
        address.setaId(aId);
        this.addressRepository.delete(address);
    }

    @Override
    public Set<Address> getAddresses() {
        return new HashSet<>(this.addressRepository.findAll());
    }
    
}
