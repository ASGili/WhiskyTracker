package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findByYear(int year);
    List<Whisky> findByDistillery_NameAndAge(String name, int age);
    List<Whisky> findByDistillery_Name(String name);
    List<Whisky> findByAge(int age);
    List<Whisky> findByDistillery_Region(String region);
}
