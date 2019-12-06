package com.ww.KnowledgeReserveForUnitTesting20.unitTest;

import com.ww.KnowledgeReserveForUnitTesting20.entity.City;
import com.ww.KnowledgeReserveForUnitTesting20.repository.CityRepository;
import com.ww.KnowledgeReserveForUnitTesting20.service.CityService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

/**
 * 测试常规的Bean。
 * 当我们进行单元测试的时候，我们希望在Spring容器中只实例化测试目标类的实例。
 */
@RunWith(SpringRunner.class)    //  声明测试是在Spring环境下运行的，这样就可以启用Spring的相关支持
@SpringBootTest     // 负责扫描配置来构建测试用的Spring上下文环境。它默认搜索@SpringBootConfiguration类，除非我们通过classes属性指定配置类，或者通过自定义内嵌的@Configuration类来指定配置
public class CityServiceUnitTest {

    /**
     * @SpringBootApplication 扩展自@Configuration，其scanBasePackages属性指定了扫描的根路径。确保测试目标类在这个路径下，
     * 而且需要明白这个路径下的所有bean都会被实例化。虽然我们已经尽可能的缩小了实例化的范围，但是我们没有避免其他无关类的实例化开销。
     * 即使如此，这种方案依然被看作是最佳的实践方案，因为它比较简单。如果我们追求“只实例化目标类”，那么可以使用下面的方式声明内嵌类：
     * @ComponentScan(value = "com.ww.KnowledgeReserveForUnitTesting20",
     *     useDefaultFilters = false,
     *     includeFilters = @ComponentScan.Filter(
     *     type = FilterType.REGEX,
     *     pattern = {"com.ww.KnowledgeReserveForUnitTesting20.CityService"})
     * )
     */
    /*@SpringBootApplication(scanBasePackages = "com.ww.KnowledgeReserveForUnitTesting20")
    static class InnerConfig {
    }*/

    /**
     * @Autowired 负责注入依赖的bean，在这里注入的是测试目标bean。
     */
    @Autowired
    private CityService cityService;

    /**
     * @MockBean 负责声明这是一个模拟的bean。在进行单元测试时，需要将测试目标的所有依赖bean声明为模拟的bean，这些模拟的bean将被注入测试目标bean。
     */
    @MockBean
    private CityRepository cityRepository;

    /**
     * 在下面方法中，我们执行了cityMapper.insert()，这只是模拟的执行了，实际上什么也没做。
     * 接下来我们调用Mockito.verify，目的是验证cityMapper.insert执行了。这正对应了对Mock概念的解释，我们只关心它是否执行了。
     */
    @Test
    public void testInsert() {
        City city = new City();
        cityRepository.save(city);
        Mockito.verify(cityRepository).save(city);
    }

    /**
     * 在下面方法中，我们使用Mockito.when()对cityMapper.selectAllCities()方法进行打桩，设定当方法被调用时，直接返回我们预设的数据。
     * 注意：只能对mock对象进行stub。
     */
    @Test
    public void getAllCities() {
        City city = new City();
        city.setId(1L);
        city.setName("杭州");
        city.setState("浙江");
        city.setCountry("CN");

        Mockito.when(cityRepository.findAll())
                .thenReturn(Collections.singletonList(city));

        List<City> result = cityService.getAllCities();
        Assertions.assertThat(result.size()).isEqualTo(1);
        Assertions.assertThat(result.get(0).getName()).isEqualTo("杭州");
    }
}