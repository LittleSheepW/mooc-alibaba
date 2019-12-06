package com.ww.KnowledgeReserveForUnitTesting20.controller;

import com.ww.KnowledgeReserveForUnitTesting20.entity.City;
import com.ww.KnowledgeReserveForUnitTesting20.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public ResponseEntity<?> getAllCities() {
        List<City> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }

    @PostMapping("/city")
    public ResponseEntity<?> newCity(@RequestBody City city) {
        cityService.save(city);
        return ResponseEntity.ok(city);
    }

}