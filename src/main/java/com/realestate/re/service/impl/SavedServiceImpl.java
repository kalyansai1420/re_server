package com.realestate.re.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.re.helper.ResourceNotFoundException;
import com.realestate.re.model.User;
import com.realestate.re.model.re.Saved;
import com.realestate.re.repo.SavedRepository;
import com.realestate.re.service.SavedService;


@Service
public class SavedServiceImpl implements SavedService {

    @Autowired
    private SavedRepository savedRepository;

    @Override
    public Saved addSaved(Saved saved) {
        return this.savedRepository.save(saved);

    }

    @Override
    public Set<Saved> getAllSaved() {

        return new HashSet<>(this.savedRepository.findAll());

    };

    @Override
    public Saved getSaved(Long saveId) {

        Optional<Saved> saved = this.savedRepository.findById(saveId);
        if (saved.isPresent()) {
            return saved.get();
        } else {
            throw new ResourceNotFoundException("saved not found");
        }

    }

    @Override
    public void deleteSaved(Long saveId) {
        Saved saved = new Saved();
        saved.setSaveId(saveId);
        this.savedRepository.delete(saved);
    }

    @Override
    public List<Saved> getSavedofUser(User user) {
        return this.savedRepository.findByUser(user);
    }

}
