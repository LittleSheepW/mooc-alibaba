package com.ww.KnowledgeReserveForUnitTesting20.unitTest;

import com.ww.KnowledgeReserveForUnitTesting20.entity.City;
import com.ww.KnowledgeReserveForUnitTesting20.repository.CityRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 就像测试controller一样，持久层的单元测试也有专门的注解支持。
 * 持久层的技术有多种，Spring提供了@JdbcTest来支持通过spring的JdbcTemplate进行持久化的测试，提供了@DataJpsTest支持通过JPA技术进行持久化的测试。
 * 默认的持久层测试是回滚的，即每一个测试方法执行完成之后，会回滚对数据库的修改；所以也可以使用外部的数据库进行测试，但多少会有些影响（比如序列的当前值）。
 */
@RunWith(SpringRunner.class)
@DataJpaTest    // 搜索配置类的逻辑和@SpringBootTest、@WebMvcTest相同
@FixMethodOrder(MethodSorters.NAME_ASCENDING)       // 指定测试方法的执行顺序，这是为了观察事务回滚的效果。
public class CityRepositoryUnitTest {

    /*@SpringBootApplication(scanBasePackages = "com.ww.KnowledgeReserveForUnitTesting20")
    @EntityScan(basePackages = "com.ww.KnowledgeReserveForUnitTesting20.entity")    // 为什么必须加入此注解？ @Entity注解标注的类并不会被@SpringBootApplication加入到Spring容器中管理！！
    static class InnerConfig {
    }*/

    private static Logger LOG = LoggerFactory.getLogger(CityRepositoryUnitTest.class);

    /**
     * 此处遇到的问题：Repository无法注入的问题！！！     用时四个小时解决
     * 除了CityControllerUnitTest、CityServiceUnitTest这两个类其余的都不能使用内部配置类，因为这两个类不需要真实的CityRepository！！！
     *
     * // TODO: 2019-12-05 目前搞不清楚原因的坑：
     * (1)为什么使用内部配置类无法将CityRepository注入到当前测试类中？
     * (2)为什么使用Application主类就可以？
     * (3)使用内部配置类还需要加入@EntityScan(basePackages = "com.ww.KnowledgeReserveForUnitTesting20.entity")，为什么主类就不需要？
     *
     */
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Before
    @After
    public void printAllCities() {
        List<City> all = cityRepository.findAll();
        LOG.info("[printAllCities] [values:{}]", all);
    }

    /**
     * 如果将test1_insert方法上的@Rollback(false)注释放开，事务不会回滚，test2_doNothing方法之后打印输出的内容会包含test1_insert方法里插入的数据。
     * 反之，如果注释掉，事务回滚，test2_doNothing方法之后打印输出的内容不包含test1_insert方法里插入的数据。
     *
     * @throws Exception
     */
    @Test
    @Rollback(false) // 禁止回滚
    public void test1_insert() throws Exception {
        City city = new City();
        city.setName("杭州");
        city.setState("浙江");
        city.setCountry("CN");
        this.entityManager.persist(city);
        LOG.info("insert a city {}", city);
    }

    @Test
    public void test2_doNothing() {
    }
}