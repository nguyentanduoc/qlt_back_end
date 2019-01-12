package com.vn.ctu.qlt.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author NTDSIVAL
 * @Date Dec 27, 2018
 */
@Entity
@Table(name = "quyen")
public class Roles implements GrantedAuthority {

	private static final long serialVersionUID = 2294593169451511696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NaturalId
	@Column(length = 60, name = "code_quyen")
	private String authority;

	@Column(name = "ten_quyen")
	private String name;

	@Override
	public String getAuthority() {
		return authority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
