package com.realestate.re.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.realestate.re.model.User;
import com.realestate.re.model.re.Property;

public interface PropertyService {

    public Property addProperty(Property property);

    public Property getProperty(Long pId);

    public Property updateProperty(Property property);

    public void deleteProperty(Long pId);

    public Set<Property> getProperties();

    public List<Object[]> countPropertiesByType();

    public List<Map<String, Object>> countPropertiesByCity();

    public List<Property> getPropertyByTime();
    public List<Property> getPropertiesByCity(String city);

    public List<Property> getPropertiesByType(String type);
    
    public List<Property> getPropertyByUser(User user);


    
}
