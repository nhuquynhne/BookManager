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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity extends BaseEntity{
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
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "story")
	private String story;
	
	@ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
	 private List<BookEntity> books = new ArrayList<>();
}
