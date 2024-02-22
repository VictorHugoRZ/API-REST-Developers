package com.developers.Schedule.repository;

import com.developers.Schedule.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IDeveloperRepository extends JpaRepository<Developer, Integer> {

    /*We will search only for one record in the database with the parameter name*/
    @Query("SELECT d FROM Developer d WHERE name = :name")
    Optional<Developer> findDevByName(String name);
}
