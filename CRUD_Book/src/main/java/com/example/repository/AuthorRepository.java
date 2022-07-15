package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.AuthorEntity;


@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, String>{

}
