package com.realestate.re.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.re.helper.ResourceFoundException;
import com.realestate.re.helper.ResourceNotFoundException;
import com.realestate.re.model.re.Property;
import com.realestate.re.repo.PropertyRepository;
import com.realestate.re.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {
    
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Property addProperty(Property property) {
        
        Property local = this.propertyRepository.findBypName(property.getpName());

        if (local != null) {
            throw new ResourceFoundException("Property already exists");
        } else {
            local = this.propertyRepository.save(property);
        }

        
        return local;
    }

    @Override
    public Property getProperty(Long pId) {
        Optional<Property> property = this.propertyRepository.findById(pId);
        if (property.isPresent()) {
            return property.get();
        } else {
            throw new ResourceNotFoundException("Property " + pId + " not found");
        }
       
    }

    @Override
    public Property updateProperty(Property property,Long pId) {
        Property property1 = this.propertyRepository.findById(pId).orElseThrow(
                () -> new ResourceNotFoundException("Property", " Id ", pId));;
        
        property1.setpId(property.getpId());
        property1.setUser(property.getUser());
        property1.setpAgeOfConstruction(property.getpAgeOfConstruction());
        property1.setpArea(property.getpArea());
        property1.setpBalcony(property.getpBalcony());
        property1.setpBedroom(property.getpBedroom());
        property1.setpDescription(property.getpDescription());
        property1.setpFacing(property.getpFacing());
        property1.setpBathroom(property.getpBathroom());
        property1.setpFurnishedStatus(property.getpFurnishedStatus());
        property1.setpName(property.getpName());
        property1.setpOfferType(property.getpOfferType());
        property1.setpPossesionStatus(property.getpPossesionStatus());
        property1.setpPrice(property.getpPrice());
        property1.setpPropertyType(property.getpPropertyType());
        property1.setpRoomFloor(property.getpRoomFloor());
        property1.setpTotalFloor(property.getpTotalFloor());
        property1.setGardens(property.getGardens());
        property1.setGym(property.getGym());
        property1.setHospitals(property.getHospitals());
        property1.setLift(property.getLift());
        property1.setMarketArea(property.getMarketArea());
        property1.setParkingArea(property.getParkingArea());
        property1.setPlayground(property.getPlayground());
        property1.setPowerBackup(property.getPowerBackup());
        property1.setSchools(property.getSchools());
        property1.setSecurity(property.getSecurity());
        property1.setShoppingMall(property.getShoppingMall());
        property1.setWaterSupply(property.getWaterSupply());
        property1.setSaved(property.getSaved());
        property1.setpBHK(property.getpBHK());
        property1.setpPhoto(property.getpPhoto());
        return this.propertyRepository.save(property1);
    }

    @Override
    public void deleteProperty(Long pId) {

        Property property = new Property();
        property.setpId(pId);
        this.propertyRepository.delete(property);
        
    }

    @Override
    public Set<Property> getProperties() {
        return new HashSet<>(this.propertyRepository.findAll());
    }
    
}
