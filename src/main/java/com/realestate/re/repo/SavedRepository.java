package com.realestate.re.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realestate.re.model.User;
import com.realestate.re.model.re.Saved;

public interface SavedRepository extends JpaRepository<Saved, Long> {
    
    public List<Saved> findByUser(User user);

    public void deleteByUser(Saved saved);
    
}
