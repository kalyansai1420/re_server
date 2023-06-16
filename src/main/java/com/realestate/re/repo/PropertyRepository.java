package com.realestate.re.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.re.model.User;
import com.realestate.re.model.re.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    // public Property findByProperty(String pName);

    public Property findBypName(String pName);

    @Query(value = "SELECT COUNT(*) as count, p_property_type FROM property  WHERE active = true GROUP BY p_property_type", nativeQuery = true)
    List<Object[]> countPropertiesByType();

    @Query(value = "select COUNT(*) as Count, a_city as City from property WHERE active = true group by a_city", nativeQuery = true)
    List<Map<String, Object>> countPropertiesByCity();

    @Query(value = "select* from property where a_city =':city' and active=true", nativeQuery = true)
    public List<Property> findPropertiesByCity(@Param("city") String city);

    @Query(value = "select* from property where p_property_type =':propertyType' and active=true", nativeQuery = true)
    public List<Property> findPropertiesByType(@Param("propertyType") String propertyType);

    public List<Property> findByUser(User user);

}
