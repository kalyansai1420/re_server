// package com.realestate.re.model.re;

// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;

// import com.fasterxml.jackson.annotation.JsonBackReference;

// @Entity
// @Table(name = "image")
// public class Image {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long iId;
//     private String iUrl;

//     @JsonBackReference
//     @ManyToOne(fetch = FetchType.LAZY)
//     private Property property;

//     public Image() {
//         super();
//         // TODO Auto-generated constructor stub
//     }

//     public Image(Long iId, String iUrl, Property property) {
//         super();
//         this.iId = iId;
//         this.iUrl = iUrl;
//         this.property = property;
//     }

//     public Long getiId() {
//         return iId;
//     }

//     public void setiId(Long iId) {
//         this.iId = iId;
//     }

//     public String getiUrl() {
//         return iUrl;
//     }

//     public void setiUrl(String iUrl) {
//         this.iUrl = iUrl;
//     }

//     public Property getProperty() {
//         return property;
//     }

//     public void setProperty(Property property) {
//         this.property = property;
//     }

// }
