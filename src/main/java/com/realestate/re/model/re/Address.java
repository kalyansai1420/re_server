// package com.realestate.re.model.re;

// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.CascadeType;
// import javax.persistence.JoinColumn;

// import javax.persistence.Id;
// import javax.persistence.OneToOne;
// import javax.persistence.Table;

// import com.fasterxml.jackson.annotation.JsonBackReference;

// @Entity
// @Table(name = "address")
// public class Address {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long aId;
//     private String aArea;
//     private String aLandmark;
//     private String aCity;
//     private String aState;
//     private String aPincode;

//     @JsonBackReference
//     @OneToOne(cascade = CascadeType.ALL, targetEntity = Property.class)
//     @JoinColumn(name = "pId")
//     private Property property;

//     public Address() {
//         super();
//     }

//     public Address(Long aId, String aArea, String aLandmark, String aCity, String aState, String aPincode,
//             Property property) {
//         super();
//         this.aId = aId;
//         this.aArea = aArea;
//         this.aLandmark = aLandmark;
//         this.aCity = aCity;
//         this.aState = aState;
//         this.aPincode = aPincode;
//         this.property = property;
//     }

//     public Long getaId() {
//         return aId;
//     }

//     public void setaId(Long aId) {
//         this.aId = aId;
//     }

//     public String getaArea() {
//         return aArea;
//     }

//     public void setaArea(String aArea) {
//         this.aArea = aArea;
//     }

//     public String getaLandmark() {
//         return aLandmark;
//     }

//     public void setaLandmark(String aLandmark) {
//         this.aLandmark = aLandmark;
//     }

//     public String getaCity() {
//         return aCity;
//     }

//     public void setaCity(String aCity) {
//         this.aCity = aCity;
//     }

//     public String getaState() {
//         return aState;
//     }

//     public void setaState(String aState) {
//         this.aState = aState;
//     }

//     public String getaPincode() {
//         return aPincode;
//     }

//     public void setaPincode(String aPincode) {
//         this.aPincode = aPincode;
//     }

//     public Property getProperty() {
//         return property;
//     }

//     public void setProperty(Property property) {
//         this.property = property;
//     }

// }
