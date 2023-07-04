package com.realestate.re.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.realestate.re.helper.ResourceFoundException;
import com.realestate.re.helper.ResourceNotFoundException;
import com.realestate.re.model.User;
import com.realestate.re.model.re.Property;
import com.realestate.re.model.re.PropertyImage;
import com.realestate.re.repo.PropertyRepository;
import com.realestate.re.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    @CacheEvict(value="properties",allEntries=true)
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
    @Cacheable(value="properties",key="#pId")
    public Property getProperty(Long pId) {
        Optional<Property> property = this.propertyRepository.findById(pId);
        if (property.isPresent()) {
            return property.get();
        } else {
            throw new ResourceNotFoundException("Property " + pId + " not found");
        }

    }

    @Override
    @CachePut(value="properties")
    public Property updateProperty(Property property) {
        Property existingProperty = this.propertyRepository.findById(property.getpId()).orElseThrow(
                () -> new ResourceNotFoundException("Property", " Id ", property.getpId()));
        ;

        // Property existingProperty = new Property();
        existingProperty.setpId(property.getpId());
        existingProperty.setUser(property.getUser());
        existingProperty.setpAgeOfConstruction(property.getpAgeOfConstruction());
        existingProperty.setpArea(property.getpArea());
        existingProperty.setpBalcony(property.getpBalcony());
        existingProperty.setpBedroom(property.getpBedroom());
        existingProperty.setpDescription(property.getpDescription());
        existingProperty.setpFacing(property.getpFacing());
        existingProperty.setpBathroom(property.getpBathroom());
        existingProperty.setpFurnishedStatus(property.getpFurnishedStatus());
        existingProperty.setpName(property.getpName());
        existingProperty.setpOfferType(property.getpOfferType());
        existingProperty.setpPossesionStatus(property.getpPossesionStatus());
        existingProperty.setpPrice(property.getpPrice());
        existingProperty.setpPropertyType(property.getpPropertyType());
        existingProperty.setpRoomFloor(property.getpRoomFloor());
        existingProperty.setpTotalFloor(property.getpTotalFloor());
        existingProperty.setGardens(property.getGardens());
        existingProperty.setGym(property.getGym());
        existingProperty.setHospitals(property.getHospitals());
        existingProperty.setLift(property.getLift());
        existingProperty.setMarketArea(property.getMarketArea());
        existingProperty.setParkingArea(property.getParkingArea());
        existingProperty.setPlayground(property.getPlayground());
        existingProperty.setPowerBackup(property.getPowerBackup());
        existingProperty.setSchools(property.getSchools());
        existingProperty.setSecurity(property.getSecurity());
        existingProperty.setShoppingMall(property.getShoppingMall());
        existingProperty.setWaterSupply(property.getWaterSupply());
        existingProperty.setSaved(property.getSaved());
        existingProperty.setpBHK(property.getpBHK());
        existingProperty.setpPhoto(property.getpPhoto());
        existingProperty.setaArea(property.getaArea());
        existingProperty.setaCity(property.getaCity());
        existingProperty.setaLandmark(property.getaLandmark());
        existingProperty.setaPincode(property.getaPincode());
        existingProperty.setaState(property.getaState());
        existingProperty.setActive(property.isActive());
        existingProperty.setSoldOut(property.isSoldOut());
        existingProperty.setUpdatedAt(property.getCreatedAt());
        existingProperty.setImages(property.getImages());
        // property.setImages(null);
        // Property updatedProperty = this.propertyRepository.save(existingProperty);
        // updatedProperty.setImages(existingProperty.getImages());

        return this.propertyRepository.save(existingProperty);
    }

    @Override
    @CacheEvict(value="properties", key="#pId")
    public void deleteProperty(Long pId) {

        Property property = this.propertyRepository.findById(pId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("property not found to delte in this for id : " + pId));
        this.propertyRepository.delete(property);

    }

    @Override
    @Cacheable("properties")
    public Set<Property> getProperties() {
        return new HashSet<>(this.propertyRepository.findAll());
    }

    @Override
    public List<Object[]> countPropertiesByType() {
        return propertyRepository.countPropertiesByType();
    }

    @Override
    public List<Map<String, Object>> countPropertiesByCity() {
        return propertyRepository.countPropertiesByCity();
    }

    @Override
    public List<Property> getPropertyByUser(User user) {
        return this.propertyRepository.findByUser(user);
    }

    @Override
    public List<Property> getPropertiesByCity(String city) {
        return this.propertyRepository.findPropertiesByCity(city);
    }

    @Override
    public List<Property> getPropertiesByType(String type) {

        return this.propertyRepository.findPropertiesByType(type);
    }

    @Override
    public List<Property> getPropertyByTime() {
        return this.propertyRepository.getPropertiesByTime();
    }

}
