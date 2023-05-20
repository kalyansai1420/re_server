package com.realestate.re.service;

import java.util.Set;

import com.realestate.re.model.re.Address;


public interface AddressService {

    public Address addAddress(Address address);

    public Address getAddress(Long aId);

    public Address updateAddress(Address address);

    public void deleteAddress(Long aId);

    public Set<Address> getAddresses();
    
}
