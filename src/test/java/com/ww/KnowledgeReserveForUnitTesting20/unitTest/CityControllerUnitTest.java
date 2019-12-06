package com.ww.KnowledgeReserveForUnitTesting20.unitTest;

import com.ww.KnowledgeReserveForUnitTesting20.controller.CityController;
import com.ww.KnowledgeReserveForUnitTesting20.entity.City;
import com.ww.KnowledgeReserveForUnitTesting20.repository.CityRepository;
import com.ww.KnowledgeReserveForUnitTesting20.service.CityService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

/**
 * 测试Controller。
 * Controller是一类特殊的bean，这类bean除了显式的依赖，还有一些系统组件的依赖。比如消息转换组件，负责将方法的返回结果转换成可以写的HTTP消息。
 * 所以，我们无法像测试上文那样对其单独实例化。Spring提供了特定的注解，配置用于测试Controller的上下文环境。
 *
 * @WebMvcTest 是特定的注解，它的职责和@SpringBootTest相同，但它只会实例化Controller。默认实例化所有的Controller，也可以指定只实例化某一到多个Controller。
 * 除此之外，@WebMvcTest还会实例化一个MockMvc的bean，用于发送http请求。我们同样需要对测试目标的依赖进行模拟，即将CityService声明为MockBean。
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CityService service;

    /**
     * Spring环境问题：
     * @WebMvcTest 就像@SpringBootTest一样，默认搜索@SpringBootConfiguration注解的类作为配置类。一般情况下，基于Spring-Boot的web应用，会创建一个启动类，并使用@SpringBootApplication，
     * 这个注解可看作@SpringBootConfiguration注解的扩展，所以很可能会搜索到这个启动类作为配置。如果项目当中有多个@SpringBootConfiguration配置类，比如有些其他的测试类创建了内部配置类，
     * 并且使用了这个注解。如果当前测试类没有使用内部类，也没有使用classes属性指定使用哪个配置类，就会因为找到了多个配置类而失败。这种情况下会有明确的错误提示信息。思考当前测试类会使用哪一个配置类，是一个很好的习惯。
     *
     * 另外一个可能的问题是：如果配置类上添加了其他的注解，比如Mybatis框架的@MapperScan注解，那么Spring会去尝试实例化Mapper实例，但是因为在测试类上我们使用的是@WebMvcTest注解，
     * Spring不会去实例化Mapper所依赖的sqlSessionFactory等自动配置的组件，最终导致依赖注解失败，无法构建Spring上下文环境。也就是说，虽然@WebMvcTest默认只实例化Controller组件，
     * 但是它同样也会遵从配置类的注解去做更多的工作。如果这些工作依赖于某些自动化配置bean，那么将会出现依赖缺失。
     * 解决这个问题的方法可能有很多种，这边提供一个自己的最佳实践：这个方案，是通过使用内部类来自定义配置。内部类只有一个@SpringBootApplication注解，指定了扫描的根路径，以缩小bean的扫描范围。
     */
    /*@SpringBootApplication(scanBasePackages = "com.ww.KnowledgeReserveForUnitTesting20")
    static class InnerConfig {
    }*/

    @Test
    public void getAllCities() throws Exception {

        City city = new City();
        city.setId(1L);
        city.setName("杭州");
        city.setState("浙江");
        city.setCountry("中国");

        Mockito.when(service.getAllCities()).
                thenReturn(Collections.singletonList(city));

        mvc.perform(MockMvcRequestBuilders.get("/cities"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("杭州")));
    }
}