package com.realestate.re.model.re;

import java.time.LocalDateTime;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.realestate.re.model.User;

@Entity
@Table(name = "property")
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
    private String pDescription;
    private String pBedroom;
    private String pBalcony;
    private String pBathroom;
    private String pRoomFloor;
    private String pTotalFloor;

    @CreationTimestamp
    private LocalDateTime CreatedAt;

    @UpdateTimestamp
    private LocalDateTime UpdatedAt;

    @JsonBackReference
    @JoinColumn(name = "createdByID")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "property")
    @JsonIgnore
    private Amenties amenties;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "property")
    @JsonIgnore
    private Address address;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "property")
    @JsonIgnore
    private Set<Image> image = new HashSet<>();

    public Amenties getAmenties() {
        return amenties;
    }

    public void setAmenties(Amenties amenties) {
        this.amenties = amenties;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Image> getImage() {
        return image;
    }

    public void setImage(Set<Image> image) {
        this.image = image;
    }

    public Property() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Property(Long pId, String pName, String pPrice, String pOfferType, String pPropertyType,
            String pFurnishedStatus, String pPossesionStatus, String pFacing, String pAgeOfConstruction, String pArea,
            String pDescription, String pBedroom, String pBalcony, String pBathroom, String pRoomFloor,
            String pTotalFloor, LocalDateTime createdAt, LocalDateTime updatedAt, User user) {
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
        CreatedAt = createdAt;
        UpdatedAt = updatedAt;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
