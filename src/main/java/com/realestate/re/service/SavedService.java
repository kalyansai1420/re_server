package com.realestate.re.service;

import java.util.List;
import java.util.Set;

import com.realestate.re.model.User;
import com.realestate.re.model.re.Saved;

public interface SavedService {



    public Saved addSaved(Saved saved);

    public Set<Saved> getAllSaved();

    public Saved getSaved(Long saveId);

    public void deleteSaved(Long saveId);

    public List<Saved> getSavedofUser(User user);

    
}
