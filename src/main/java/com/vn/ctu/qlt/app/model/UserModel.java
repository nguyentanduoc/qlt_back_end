package com.vn.ctu.qlt.app.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author NTDSIVAL
 * @Date Dec 25, 2018
 */
@Entity
@Table(name="tai_khoan")
public class UserModel implements UserDetails {

	private static final long serialVersionUID = -1117297133355031207L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "ten_dang_nhap")
	@JsonProperty("userName")
	private String userName;
	
	@Column(name = "email")
	@JsonProperty("email")
	private String email;
	
	@JsonIgnore
	@Column(name = "mat_khau")
	@JsonProperty("password")
	private String password;
	
	@Column(name = "hoat_dong")
	@JsonProperty("enabled")
	private Boolean enabled;
	
	@Column(name="ngay_tao")
	@JsonProperty("date_create")
	private Date dateCreate;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "quyen_tai_khoan", joinColumns = @JoinColumn(name = "tai_khoan_id"), inverseJoinColumns = @JoinColumn(name = "quyen_id"))
	@JsonProperty("authorities")
	private Collection<Roles> authorities;
	
	@Column(name = "han_dung")
	private Boolean accountNonExpired;
	
	@Column(name = "xac_thuc")
	private Boolean credentialsNonExpired;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<Roles> authorities) {
		this.authorities = authorities;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
}
