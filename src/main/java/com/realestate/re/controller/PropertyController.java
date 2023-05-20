package com.realestate.re.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.re.model.re.Property;
import com.realestate.re.payload.ApiResponse;
import com.realestate.re.service.AddressService;
import com.realestate.re.service.AmentiesService;
import com.realestate.re.service.PropertyService;

@RestController
@RequestMapping("/property")
@CrossOrigin("*")
public class PropertyController {
    
    @Autowired
    private PropertyService propertyService;

    @Autowired
    private AmentiesService amentiesService;

    @Autowired
    private AddressService addressService;

    //add Property
    @PostMapping("/")
    public ResponseEntity<Property> addProperty(@RequestBody Property property) {
        Property property1 = new Property();
        property1.setpId(property.getpId());
        property1.setAddress(property.getAddress());
        property1.setAmenties(property.getAmenties());
        property1.setImage(property.getImage());
        property1.setUser(property.getUser());
        property1.setCreatedAt(property.getCreatedAt());
        property1.setUpdatedAt(property.getUpdatedAt());
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
        return ResponseEntity.ok(this.propertyService.addProperty(property1));
    }

    //get property
    @GetMapping("{propertyId}")
    public Property getProperty(@PathVariable("propertyId") Long propertyId) {
        return this.propertyService.getProperty(propertyId);
    }

    //get properties
    @GetMapping("/")
    public Set<Property> getProperties() {
        return this.propertyService.getProperties();
    }

    //update Property
    @PutMapping("/{propertyId}")
    public ResponseEntity<Property> updateProperty(@RequestBody Property property,
            @PathVariable("propertyId") Long pId) {

        Property updatedProperty = this.propertyService.updateProperty(property, pId);

        return ResponseEntity.ok(updatedProperty);
       
    }

    //delete Property
    @DeleteMapping("/{propertyId}")
    public ResponseEntity<ApiResponse> deleteProperty(@PathVariable("propertyId") Long propertyId) {
        this.propertyService.deleteProperty(propertyId);
        return new ResponseEntity(new ApiResponse("Property deleted successfully",true),HttpStatus.OK);
    }
    



}
