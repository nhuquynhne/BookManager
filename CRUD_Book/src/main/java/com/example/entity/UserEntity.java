package com.example.entity;

import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private String id;
//
//	@Column(name = "createdBy")
//	private String createdBy;
//
//	@Column(name = "createdDate")
//	private Date createdDate;
//
//	@Column(name = "modifiedBy")
//	private String modifiedBy;
//
//	@Column(name = "modifiedDate")
//	private Date modifiedDate;

	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "fullName", nullable = false)
	private String fullName;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "phone", unique = true)
	private String phone;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", 
			joinColumns = @JoinColumn(name = "user_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
	private List<RoleEntity> roles = new ArrayList<>();
	
	@ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
	 private List<BookEntity> books = new ArrayList<>();
}
