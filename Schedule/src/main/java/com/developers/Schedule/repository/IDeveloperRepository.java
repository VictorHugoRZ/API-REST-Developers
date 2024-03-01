package com.developers.Schedule.repository;

import com.developers.Schedule.DevelopersScheduleApplication;
import com.developers.Schedule.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IDeveloperRepository extends JpaRepository<Developer, Integer> {

    /*We will search only for one record in the database with the parameter name in this Query, this
    * is util when we have to make more complex queries to our database
    *
    @Query("SELECT d FROM Developer d WHERE name = :name")
    Optional<Developer> findDevByName(String name);*/

    /*We can also do this without a Query annotation, we have to specify in the method name:
    * findBy -> field of the class that we need to find*/
    Optional<Developer> findByName(String name);

    /*This is a consult that searches by Nickname parameter ignoring whether they are uppercase or lowercase*/
    Optional<Developer> findByNicknameIgnoreCase(String nickname);

}
