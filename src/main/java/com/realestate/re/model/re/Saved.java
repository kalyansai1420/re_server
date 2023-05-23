package com.realestate.re.model.re;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.realestate.re.model.User;

@Entity
@Table(name = "saved")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "saveId")
public class Saved {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long saveId;
    

    @ManyToOne
    @JoinColumn(name = "pId")
    private Property property;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;


    
    public Saved() {
        super();
    }


    public Saved(Long saveId, Property property, User user) {
        super();
        this.saveId = saveId;
        this.property = property;
        this.user = user;
    }

    
    public Long getSaveId() {
        return saveId;
    }


    public void setSaveId(Long saveId) {
        this.saveId = saveId;
    }

    
    public Property getProperty() {
        return property;
    }


    public void setProperty(Property property) {
        this.property = property;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

}
