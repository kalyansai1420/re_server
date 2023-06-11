package com.realestate.re.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.realestate.re.helper.GrantedAuthorityDeserializer;
import com.realestate.re.helper.GrantedAuthoritySerializer;
import com.realestate.re.model.re.Property;
import com.realestate.re.model.re.Saved;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uId")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uId")
@Entity
@Table(name = "user")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uId;
	private String username;
	private String email;
	private String phonenumber;
	private String password;
	private boolean enabled = true;

	// @JsonSerialize(using = GrantedAuthoritySerializer.class)
	// @JsonDeserialize(using = GrantedAuthorityDeserializer.class)
	// private Set<GrantedAuthority> authorities;

	public User() {
		super();
	}

	// user to role
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public void updateUserRole(Set<UserRole> userRoles) {
		this.userRoles.clear();
		this.userRoles.addAll(userRoles);
	}

	// one user has many properties
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	@JsonIgnoreProperties("user")
	private Set<Property> Property = new HashSet<>();

	@JsonIgnore
	public Set<Property> getProperty() {
		return Property;
	}

	public void setProperty(Set<Property> property) {
		Property = property;
	}

	// one user has one saved table
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	private Saved saved;

	public Saved getSaved() {
		return saved;
	}

	public void setSaved(Saved saved) {
		this.saved = saved;
	}

	public User(Long uId, String username, String email, String phonenumber, String password, boolean enabled) {
		super();
		this.uId = uId;
		this.username = username;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.enabled = enabled;
	}

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<Authority> set = new HashSet<>();
		this.userRoles.forEach(userRole -> set.add(new Authority(userRole.getRole().getRoleName())));

		return set;

	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public User orElseThrow(Object object) {
		return null;
	}

	// public User orElseThrow(Object object) {
	// return null;
	// }

}
