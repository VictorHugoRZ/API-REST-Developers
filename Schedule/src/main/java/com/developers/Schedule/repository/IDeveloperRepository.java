package com.developers.Schedule.repository;

import com.developers.Schedule.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeveloperRepository extends JpaRepository<Developer, Integer> {
}
