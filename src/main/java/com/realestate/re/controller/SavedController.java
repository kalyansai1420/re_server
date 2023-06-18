package com.realestate.re.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.re.model.User;
import com.realestate.re.model.re.Saved;
import com.realestate.re.payload.ApiResponse;
import com.realestate.re.repo.SavedRepository;
import com.realestate.re.service.SavedService;

@RestController
@RequestMapping("/saved")
@CrossOrigin("*")
public class SavedController {

    @Autowired
    private SavedService savedService;

    // add saved
    @PostMapping("/")
    public ResponseEntity<Saved> addSaved(@RequestBody Saved saved) {
        Saved addedSaved = savedService.addSaved(saved);
        return ResponseEntity.ok(addedSaved);
    }

    // get saved
    @GetMapping("/{savedId}")
    public Saved getSaved(@PathVariable("savedId") Long saveId) {
        return this.savedService.getSaved(saveId);
    }

    // get all saved
    @GetMapping("/")
    public Set<Saved> getAllSaved() {
        return this.savedService.getAllSaved();
    }

    // delete saved
    @DeleteMapping("/{savedId}")
    public ResponseEntity<ApiResponse>  deleteSaved(@PathVariable("savedId") Long savedId) {
        this.savedService.deleteSaved(savedId);
        return new ResponseEntity(new ApiResponse("Saved deleted successfully :" +savedId, true), HttpStatus.OK);
    }

    // get saved of user
    @GetMapping("/user/{uId}")
    public List<Saved> getSavedofUser(@PathVariable("uId") Long uId) {
        User user = new User();
        user.setuId(uId);
        return this.savedService.getSavedofUser(user);
    }

    @GetMapping("/likeByProperty")
    public ResponseEntity<List<Map<String, Object>>> countLikesByProperty() {
        List<Map<String, Object>> likesByProperty = savedService.countLikesByProperty();
        return ResponseEntity.ok(likesByProperty);
    }
    @GetMapping("/likeByPropertydetails")
    public ResponseEntity<List<Map<String, Object>>> getLikesByPropertyDetails() {
        List<Map<String, Object>> likesByPropertydetails = savedService.getLikesByPropertyDetails();
        return ResponseEntity.ok(likesByPropertydetails);
    }



    // @GetMapping("/likeByProperty/{pId}")


    

}
