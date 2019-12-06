package com.ww.KnowledgeReserveForUnitTesting20.integrationTesting;

import com.ww.KnowledgeReserveForUnitTesting20.entity.City;
import com.ww.KnowledgeReserveForUnitTesting20.service.CityService;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 从中间层开始测试
 * 集成测试不是非要从最顶层开始测试，我们也可以从service层开始测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityServiceIntegrationTest {

    private static Logger LOG = LoggerFactory.getLogger(CityServiceIntegrationTest.class);

    @Autowired
    private CityService cityService;

    /*@SpringBootApplication(scanBasePackages = "com.ww.KnowledgeReserveForUnitTesting20")
    static class InnerConfig {
    }*/

    /**
     * 以下代码的测试方案和上文的controller集成测试方案相同，都是测试新增操作，并在测试前后打印当前数据集，来演示是否支持事务回滚。
     */

    @Before
    @After
    public void printAllCities() {
        List<City> cities = cityService.getAllCities();
        LOG.info("[getAllCities] [cities = {}]", cities);
    }

    @Test
    @Transactional
    public void test1_insert() {
        City city = new City();
        city.setName("杭州");
        city.setState("浙江");
        city.setCountry("CN");

        cityService.save(city);
        LOG.info("insert a new city {}", city);
    }

    @Test
    public void test2_doNothind() {

    }

}