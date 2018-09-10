package com.example.java1mysql.dao;

import com.example.java1mysql.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPerson extends JpaRepository<Person,Long> {
}
