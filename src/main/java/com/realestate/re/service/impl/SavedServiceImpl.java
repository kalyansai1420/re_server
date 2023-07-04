package com.realestate.re.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.realestate.re.helper.ResourceNotFoundException;
import com.realestate.re.model.User;
import com.realestate.re.model.re.Property;
import com.realestate.re.model.re.Saved;
import com.realestate.re.repo.SavedRepository;
import com.realestate.re.repo.UserRepository;
import com.realestate.re.service.SavedService;

@Service
public class SavedServiceImpl implements SavedService {

    @Autowired
    private SavedRepository savedRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @CacheEvict(value="saveds",allEntries=true)
    public Saved addSaved(Saved saved) {
        User user = saved.getUser();
        Property property = saved.getProperty();
        saved.setUser(user);
        saved.setProperty(property);
        return savedRepository.save(saved);

    }

    @Override
    @Cacheable("saveds")
    public Set<Saved> getAllSaved() {

        return new HashSet<>(this.savedRepository.findAll());

    };

    @Override
    @Cacheable(value="saveds",key="#saveId")
    public Saved getSaved(Long saveId) {

        Optional<Saved> saved = this.savedRepository.findById(saveId);
        if (saved.isPresent()) {
            return saved.get();
        } else {
            throw new ResourceNotFoundException("saved not found");
        }

    }

    @Override
    @CacheEvict(value="saveds", key="#saveId")
    public void deleteSaved(Long saveId) {
        Saved saved = this.savedRepository.findById(saveId).orElseThrow(
				() -> new ResourceNotFoundException("Hello", " Id ", saveId));
        this.savedRepository.delete(saved);
    }

    @Override
    public List<Saved> getSavedofUser(User user) {
        return this.savedRepository.findByUser(user);
    }

    @Override
    public List<Map<String, Object>> countLikesByProperty() {

        return savedRepository.countLikesByProperty();

    }

    

    @Override
    public int getLikesByPropertyId(Property property) {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLikesByPropertyId'");

    }

    @Override
    public List<Map<String, Object>> getLikesByPropertyDetails() {
        return savedRepository.getLikesByPropertyDetails();
  }

}
