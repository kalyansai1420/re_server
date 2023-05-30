package com.realestate.re.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.realestate.re.model.re.Property;

public interface PropertyService {

    public Property addProperty(Property property);

    public Property getProperty(Long pId);

    public Property updateProperty(Property property,Long pId);

    public void deleteProperty(Long pId);

    public Set<Property> getProperties();

    public List<Object[]> countPropertiesByType();

    public List<Map<String, Object>> countPropertiesByCity();
    
}
