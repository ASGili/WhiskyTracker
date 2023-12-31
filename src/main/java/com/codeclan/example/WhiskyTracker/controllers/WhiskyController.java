package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getWhiskiesByYear(
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "distilleryName", required = false) String name,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "region", required = false) String region
            ){
        if (year != null) {
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        } else if (age != null && name != null){
            return new ResponseEntity<>(whiskyRepository.findByDistillery_NameAndAge(name, age), HttpStatus.OK);
        } else if (name == null && age != null){
            return new ResponseEntity<>(whiskyRepository.findByAge(age), HttpStatus.OK);
        } else if (age == null && name != null){
            return new ResponseEntity<>(whiskyRepository.findByDistillery_Name(name), HttpStatus.OK);
        } else if (region != null){
            return new ResponseEntity<>(whiskyRepository.findByDistillery_Region(region),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
        }
    }


}
