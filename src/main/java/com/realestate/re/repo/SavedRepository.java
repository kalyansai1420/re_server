package com.realestate.re.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.realestate.re.model.User;
import com.realestate.re.model.re.Property;
import com.realestate.re.model.re.Saved;

public interface SavedRepository extends JpaRepository<Saved, Long> {
    
    public List<Saved> findByUser(User user);

    public void deleteByUser(Saved saved);


    @Query(value="select count(*) as likes,saved.p_id from saved group by p_id",nativeQuery = true)
    List<Map<String, Object>> countLikesByProperty();

    @Query(value="SELECT COUNT(*) AS likes, property.* FROM saved INNER JOIN property ON saved.p_id = property.p_id GROUP BY saved.p_id limit 5;", nativeQuery = true)
    List<Map<String, Object>> getLikesByPropertyDetails();   

    @Query(value = "SELECT COUNT(s) AS likes FROM Saved s WHERE s.property.p_id = :propertyId",nativeQuery=true)
    public int getLikesByPropertyId(Long propertyId);
    
}
