package com.project.alumiar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.alumiar.models.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {}
