package com.ww.KnowledgeReserveForUnitTesting20.repository;

import com.ww.KnowledgeReserveForUnitTesting20.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Sun
 * @create: 2019-12-05 17:57
 * @version: v1.0
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
