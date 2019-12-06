package com.ww.KnowledgeReserveForUnitTesting20.service;

import com.ww.KnowledgeReserveForUnitTesting20.entity.City;

import java.util.List;

public interface CityService {

    List<City> getAllCities();

    void save(City city);
}