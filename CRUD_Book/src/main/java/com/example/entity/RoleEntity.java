package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity extends BaseEntity{

	@Column(name = "name", nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private List<UserEntity> users = new ArrayList<>();

	public RoleEntity(String name) {
		this.name = name;
	}
	
}
