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
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity extends BaseEntity{
	//private static final long serialVersionUID = -4988455421375043688L;
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
	
	@Column(name ="name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "namXB", nullable = false)
	private String namXB;
	
	@Column(name = "price",  nullable = false)
	private Integer price;
	
	@Column(name = "numTitle",  nullable = false)
	private Integer numTitle;
	
	@Column(name = "numNow",  nullable = false)
	private Integer numNow;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "category_book",
			joinColumns = @JoinColumn(name = "book_id",  nullable = false),
			inverseJoinColumns = @JoinColumn(name = "category_id",  nullable = false))
    private List<CategoryEntity> categories = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "author_book",
			joinColumns = @JoinColumn(name = "book_id",  nullable = false),
			inverseJoinColumns = @JoinColumn(name = "author_id",  nullable = false))
    private List<AuthorEntity> authors = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "nxb_book",
			joinColumns = @JoinColumn(name = "book_id",  nullable = false),
			inverseJoinColumns = @JoinColumn(name = "nxb_id",  nullable = false))
    private List<NXBEntity> nxbs = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "book_user",
			joinColumns = @JoinColumn(name = "book_id",  nullable = false),
			inverseJoinColumns = @JoinColumn(name = "user_id",  nullable = false))
    private List<UserEntity> users = new ArrayList<>();
}
