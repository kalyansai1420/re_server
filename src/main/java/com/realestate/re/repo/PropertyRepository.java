package com.realestate.re.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.realestate.re.model.User;
import com.realestate.re.model.re.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    
    // public Property findByProperty(String pName);

    public Property findBypName(String pName);


    @Query(value = "SELECT COUNT(*) as count, p_property_type FROM property GROUP BY p_property_type", nativeQuery = true)
    List<Object[]> countPropertiesByType();


    @Query(value = "select COUNT(*) as Count, a_city as City from property group by a_city",nativeQuery = true)
    List<Map<String, Object>> countPropertiesByCity();

    public List<Property> findByUser(User user);


}
