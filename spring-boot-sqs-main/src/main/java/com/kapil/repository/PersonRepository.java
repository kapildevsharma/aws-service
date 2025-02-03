package com.kapil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kapil.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}

