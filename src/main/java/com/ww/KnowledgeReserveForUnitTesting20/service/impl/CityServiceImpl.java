package com.ww.KnowledgeReserveForUnitTesting20.service.impl;

import com.ww.KnowledgeReserveForUnitTesting20.entity.City;
import com.ww.KnowledgeReserveForUnitTesting20.repository.CityRepository;
import com.ww.KnowledgeReserveForUnitTesting20.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Sun
 * @create: 2019-12-06 10:42
 * @version: v1.0
 */

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }
}
