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
// @Table(name = "amenties")
// public class Amenties {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long amenId;
//     private Boolean lift;
//     private Boolean security;
//     private Boolean playground;
//     private Boolean gardens;
//     private Boolean waterSupply;
//     private Boolean powerBackup;
//     private Boolean parkingArea;
//     private Boolean gym;
//     private Boolean shoppingMall;
//     private Boolean hospitals;
//     private Boolean schools;
//     private Boolean marketArea;

//     @JsonBackReference
//     @OneToOne(cascade = CascadeType.ALL, targetEntity = Property.class)
//     @JoinColumn(name = "pId")
//     private Property property;

//     public Amenties() {
//         super();
//         // TODO Auto-generated constructor stub
//     }

//     public Amenties(Long amenId, Boolean lift, Boolean security, Boolean playground, Boolean gardens,
//             Boolean waterSupply, Boolean powerBackup, Boolean parkingArea, Boolean gym, Boolean shoppingMall,
//             Boolean hospitals, Boolean schools, Boolean marketArea, Property property) {
//         super();
//         this.amenId = amenId;
//         this.lift = lift;
//         this.security = security;
//         this.playground = playground;
//         this.gardens = gardens;
//         this.waterSupply = waterSupply;
//         this.powerBackup = powerBackup;
//         this.parkingArea = parkingArea;
//         this.gym = gym;
//         this.shoppingMall = shoppingMall;
//         this.hospitals = hospitals;
//         this.schools = schools;
//         this.marketArea = marketArea;
//         this.property = property;
//     }

//     public Long getAmenId() {
//         return amenId;
//     }

//     public void setAmenId(Long amenId) {
//         this.amenId = amenId;
//     }

//     public Boolean getLift() {
//         return lift;
//     }

//     public void setLift(Boolean lift) {
//         this.lift = lift;
//     }

//     public Boolean getSecurity() {
//         return security;
//     }

//     public void setSecurity(Boolean security) {
//         this.security = security;
//     }

//     public Boolean getPlayground() {
//         return playground;
//     }

//     public void setPlayground(Boolean playground) {
//         this.playground = playground;
//     }

//     public Boolean getGardens() {
//         return gardens;
//     }

//     public void setGardens(Boolean gardens) {
//         this.gardens = gardens;
//     }

//     public Boolean getWaterSupply() {
//         return waterSupply;
//     }

//     public void setWaterSupply(Boolean waterSupply) {
//         this.waterSupply = waterSupply;
//     }

//     public Boolean getPowerBackup() {
//         return powerBackup;
//     }

//     public void setPowerBackup(Boolean powerBackup) {
//         this.powerBackup = powerBackup;
//     }

//     public Boolean getParkingArea() {
//         return parkingArea;
//     }

//     public void setParkingArea(Boolean parkingArea) {
//         this.parkingArea = parkingArea;
//     }

//     public Boolean getGym() {
//         return gym;
//     }

//     public void setGym(Boolean gym) {
//         this.gym = gym;
//     }

//     public Boolean getShoppingMall() {
//         return shoppingMall;
//     }

//     public void setShoppingMall(Boolean shoppingMall) {
//         this.shoppingMall = shoppingMall;
//     }

//     public Boolean getHospitals() {
//         return hospitals;
//     }

//     public void setHospitals(Boolean hospitals) {
//         this.hospitals = hospitals;
//     }

//     public Boolean getSchools() {
//         return schools;
//     }

//     public void setSchools(Boolean schools) {
//         this.schools = schools;
//     }

//     public Boolean getMarketArea() {
//         return marketArea;
//     }

//     public void setMarketArea(Boolean marketArea) {
//         this.marketArea = marketArea;
//     }

//     public Property getProperty() {
//         return property;
//     }

//     public void setProperty(Property property) {
//         this.property = property;
//     }

// }
