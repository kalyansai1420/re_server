package com.realestate.re.model.re;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.realestate.re.model.User;

@Entity
@Table(name = "property")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pId")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;
    private String pName;
    private String pPrice;
    private String pOfferType;
    private String pPropertyType;
    private String pFurnishedStatus;
    private String pPossesionStatus;
    private String pFacing;
    private String pAgeOfConstruction;
    private String pArea;

    @Column(length = 1200)
    private String pDescription;
    private String pBedroom;
    private String pBalcony;
    private String pBathroom;
    private String pRoomFloor;
    private String pTotalFloor;
    private String pBHK;
    private Boolean lift;
    private Boolean security;
    private Boolean playground;
    private Boolean gardens;
    private Boolean waterSupply;
    private Boolean powerBackup;
    private Boolean parkingArea;
    private Boolean gym;
    private Boolean shoppingMall;
    private Boolean hospitals;
    private Boolean schools;
    private Boolean marketArea;
    private String aArea;
    private String aLandmark;
    private String aCity;
    private String aState;
    private String aPincode;
    private String pPhoto;


    private boolean active = false;
    private boolean soldOut = false;


    @CreationTimestamp
    private LocalDateTime CreatedAt;

    @UpdateTimestamp
    private LocalDateTime UpdatedAt;


    


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    //many property under one user
    @JoinColumn(name = "uId")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    
    //many properties under one cart
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "property")
    @JsonIgnoreProperties("property")
    private Set<Saved> saved = new HashSet<>();

    @JsonIgnore
    public Set<Saved> getSaved() {
        return saved;
    }

    public void setSaved(Set<Saved> saved) {
        this.saved = saved;
    }

    // one property has many images    
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("property")
    private List<PropertyImage> images = new ArrayList<>();

  
    public List<PropertyImage> getImages() {
        return images;
    }

    public void setImages(List<PropertyImage> images) {
        this.images = images;
    }

    public void addImage(PropertyImage image) {
        images.add(image);
        image.setProperty(this);
    }

    public void removeImage(PropertyImage image) {
        images.remove(image);
        image.setProperty(null);
    }
    

    public Property() {
        super();
    }


    public Property(Long pId, String pName, String pPrice, String pOfferType, String pPropertyType,
            String pFurnishedStatus, String pPossesionStatus, String pFacing, String pAgeOfConstruction, String pArea,
            String pDescription, String pBedroom, String pBalcony, String pBathroom, String pRoomFloor,
            String pTotalFloor, String pBHK, Boolean lift, Boolean security, Boolean playground, Boolean gardens,
            Boolean waterSupply, Boolean powerBackup, Boolean parkingArea, Boolean gym, Boolean shoppingMall,
            Boolean hospitals, Boolean schools, Boolean marketArea, String aArea, String aLandmark, String aCity,
            String aState, String aPincode, String pPhoto, User user, Set<Saved> saved) {
        super();
        this.pId = pId;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pOfferType = pOfferType;
        this.pPropertyType = pPropertyType;
        this.pFurnishedStatus = pFurnishedStatus;
        this.pPossesionStatus = pPossesionStatus;
        this.pFacing = pFacing;
        this.pAgeOfConstruction = pAgeOfConstruction;
        this.pArea = pArea;
        this.pDescription = pDescription;
        this.pBedroom = pBedroom;
        this.pBalcony = pBalcony;
        this.pBathroom = pBathroom;
        this.pRoomFloor = pRoomFloor;
        this.pTotalFloor = pTotalFloor;
        this.pBHK = pBHK;
        this.lift = lift;
        this.security = security;
        this.playground = playground;
        this.gardens = gardens;
        this.waterSupply = waterSupply;
        this.powerBackup = powerBackup;
        this.parkingArea = parkingArea;
        this.gym = gym;
        this.shoppingMall = shoppingMall;
        this.hospitals = hospitals;
        this.schools = schools;
        this.marketArea = marketArea;
        this.aArea = aArea;
        this.aLandmark = aLandmark;
        this.aCity = aCity;
        this.aState = aState;
        this.aPincode = aPincode;
        this.pPhoto = pPhoto;
        this.user = user;
        this.saved = saved;
    }


    public Long getpId() {
        return pId;
    }


    public void setpId(Long pId) {
        this.pId = pId;
    }


    public String getpName() {
        return pName;
    }


    public void setpName(String pName) {
        this.pName = pName;
    }


    public String getpPrice() {
        return pPrice;
    }


    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }


    public String getpOfferType() {
        return pOfferType;
    }


    public void setpOfferType(String pOfferType) {
        this.pOfferType = pOfferType;
    }


    public String getpPropertyType() {
        return pPropertyType;
    }


    public void setpPropertyType(String pPropertyType) {
        this.pPropertyType = pPropertyType;
    }


    public String getpFurnishedStatus() {
        return pFurnishedStatus;
    }


    public void setpFurnishedStatus(String pFurnishedStatus) {
        this.pFurnishedStatus = pFurnishedStatus;
    }


    public String getpPossesionStatus() {
        return pPossesionStatus;
    }


    public void setpPossesionStatus(String pPossesionStatus) {
        this.pPossesionStatus = pPossesionStatus;
    }


    public String getpFacing() {
        return pFacing;
    }


    public void setpFacing(String pFacing) {
        this.pFacing = pFacing;
    }


    public String getpAgeOfConstruction() {
        return pAgeOfConstruction;
    }


    public void setpAgeOfConstruction(String pAgeOfConstruction) {
        this.pAgeOfConstruction = pAgeOfConstruction;
    }


    public String getpArea() {
        return pArea;
    }


    public void setpArea(String pArea) {
        this.pArea = pArea;
    }


    public String getpDescription() {
        return pDescription;
    }


    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }


    public String getpBedroom() {
        return pBedroom;
    }


    public void setpBedroom(String pBedroom) {
        this.pBedroom = pBedroom;
    }


    public String getpBalcony() {
        return pBalcony;
    }


    public void setpBalcony(String pBalcony) {
        this.pBalcony = pBalcony;
    }


    public String getpBathroom() {
        return pBathroom;
    }


    public void setpBathroom(String pBathroom) {
        this.pBathroom = pBathroom;
    }


    public String getpRoomFloor() {
        return pRoomFloor;
    }


    public void setpRoomFloor(String pRoomFloor) {
        this.pRoomFloor = pRoomFloor;
    }


    public String getpTotalFloor() {
        return pTotalFloor;
    }


    public void setpTotalFloor(String pTotalFloor) {
        this.pTotalFloor = pTotalFloor;
    }


    public String getpBHK() {
        return pBHK;
    }


    public void setpBHK(String pBHK) {
        this.pBHK = pBHK;
    }


    public Boolean getLift() {
        return lift;
    }


    public void setLift(Boolean lift) {
        this.lift = lift;
    }


    public Boolean getSecurity() {
        return security;
    }


    public void setSecurity(Boolean security) {
        this.security = security;
    }


    public Boolean getPlayground() {
        return playground;
    }


    public void setPlayground(Boolean playground) {
        this.playground = playground;
    }


    public Boolean getGardens() {
        return gardens;
    }


    public void setGardens(Boolean gardens) {
        this.gardens = gardens;
    }


    public Boolean getWaterSupply() {
        return waterSupply;
    }


    public void setWaterSupply(Boolean waterSupply) {
        this.waterSupply = waterSupply;
    }


    public Boolean getPowerBackup() {
        return powerBackup;
    }


    public void setPowerBackup(Boolean powerBackup) {
        this.powerBackup = powerBackup;
    }


    public Boolean getParkingArea() {
        return parkingArea;
    }


    public void setParkingArea(Boolean parkingArea) {
        this.parkingArea = parkingArea;
    }


    public Boolean getGym() {
        return gym;
    }


    public void setGym(Boolean gym) {
        this.gym = gym;
    }


    public Boolean getShoppingMall() {
        return shoppingMall;
    }


    public void setShoppingMall(Boolean shoppingMall) {
        this.shoppingMall = shoppingMall;
    }


    public Boolean getHospitals() {
        return hospitals;
    }


    public void setHospitals(Boolean hospitals) {
        this.hospitals = hospitals;
    }


    public Boolean getSchools() {
        return schools;
    }


    public void setSchools(Boolean schools) {
        this.schools = schools;
    }


    public Boolean getMarketArea() {
        return marketArea;
    }


    public void setMarketArea(Boolean marketArea) {
        this.marketArea = marketArea;
    }


    public String getaArea() {
        return aArea;
    }


    public void setaArea(String aArea) {
        this.aArea = aArea;
    }


    public String getaLandmark() {
        return aLandmark;
    }


    public void setaLandmark(String aLandmark) {
        this.aLandmark = aLandmark;
    }


    public String getaCity() {
        return aCity;
    }


    public void setaCity(String aCity) {
        this.aCity = aCity;
    }


    public String getaState() {
        return aState;
    }


    public void setaState(String aState) {
        this.aState = aState;
    }


    public String getaPincode() {
        return aPincode;
    }


    public void setaPincode(String aPincode) {
        this.aPincode = aPincode;
    }


    public String getpPhoto() {
        return pPhoto;
    }


    public void setpPhoto(String pPhoto) {
        this.pPhoto = pPhoto;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }

   

   


   

}
