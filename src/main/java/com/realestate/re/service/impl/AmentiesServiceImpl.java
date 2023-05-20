package com.realestate.re.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.re.helper.ResourceNotFoundException;
import com.realestate.re.model.re.Amenties;
import com.realestate.re.repo.AmentiesRepository;
import com.realestate.re.service.AmentiesService;

@Service
public class AmentiesServiceImpl implements AmentiesService {
    
    @Autowired
    private AmentiesRepository amentiesRepository;

    @Override
    public Amenties addAmenties(Amenties amenties) {
        return this.amentiesRepository.save(amenties);
    }

    @Override
    public Amenties getAmenties(Long amenId) {
        Optional<Amenties> amenties = this.amentiesRepository.findById(amenId);
        if (amenties.isPresent()) {
            return amenties.get();
        } else {
            throw new ResourceNotFoundException("Amenties not found");
        }
    }

    @Override
    public Amenties updateAmenties(Amenties amenties) {
        Amenties amenties1 = new Amenties();
        amenties1.setGardens(amenties.getGardens());
        amenties1.setGym(amenties.getGym());
        amenties1.setHospitals(amenties.getHospitals());
        amenties1.setLift(amenties.getLift());
        amenties1.setMarketArea(amenties.getMarketArea());
        amenties1.setParkingArea(amenties.getParkingArea());
        amenties1.setPlayground(amenties.getPlayground());
        amenties1.setPowerBackup(amenties.getPowerBackup());
        amenties1.setSchools(amenties.getSchools());
        amenties1.setSecurity(amenties.getSecurity());
        amenties1.setShoppingMall(amenties.getShoppingMall());
        amenties1.setWaterSupply(amenties.getWaterSupply());
        return this.amentiesRepository.save(amenties1);
    }

    @Override
    public void deleteAmenties(Long amenId) {
        Amenties amenties = new Amenties();
        amenties.setAmenId(amenId);
        this.amentiesRepository.delete(amenties);
    }

    @Override
    public Set<Amenties> getAmentieses() {
        return new HashSet<>(this.amentiesRepository.findAll());
    }
    
}
