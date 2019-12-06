package com.ww.KnowledgeReserveForUnitTesting20.integrationTesting;

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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

/**
 * 集成测试时会超脱一个类的范围，我们需要保证自测试目标类及以下的依赖类，都能够在spring容器中被实例化，最简单的方式莫过于构建完整的spring上下文。
 * 虽然这样一来，会有很多和测试目标无关的类也会被实例化，但是我们省去了精心设计初始化bean的工夫，而且也间接的达到了“测试构建完整的spring上下文”的目的。
 */
@RunWith(SpringRunner.class)
@SpringBootTest  // 集成测试时使用@SpringBootTest注解，指定配置类为项目启动类。如果我们的项目是基于spring-cloud的微服务环境，那么也可以使用内部配置类来减少服务注册等相关的配置。
@AutoConfigureMockMvc    // 为了实例化MockMvc实例，用来发送http请求
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityControllerIntegrationTest {

    private static Logger LOG = LoggerFactory.getLogger(CityControllerIntegrationTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CityRepository cityRepository;

    /*@SpringBootApplication(scanBasePackages = "com.ww.KnowledgeReserveForUnitTesting20")
    static class InnerConfig {
    }*/

    /**
     * 以下代码主要测试新增数据记录的请求，并在测试前后分别请求并打印当前的数据记录集。
     * 我们可以看到，在test1_insertCity方法运行之后打印的数据集，会比在此之前打印的数据集多一条记录，而这条记录正是我们申请新增的数据记录。
     * test2_doNothind是一个辅助的测试方法，在完成test1_insertCity方法之后，开始执行test2_doNothind测试。而测试前的打印数据记录集的行为，
     * 可以让我们观察到test1_insertCity测试中新增的数据是否发生回滚。
     */

    @Before
    @After
    public void getAllCities() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cities"))
                .andDo(result -> {
                    String content = result.getResponse().getContentAsString();
                    LOG.info("[getAllCities] [cities = {}]", content);
                });
    }

    /**
     * 实验证明，集成测试依然可以支持数据库操作回滚，方案就是在测试方法上使用@Transactional注解，标识事务性操作。同时依然可以使用@Rollback来设置是否回滚。
     * @throws Exception
     */
    @Test
    @Transactional
//    @Rollback(false)
    public void test1_insertCity() throws Exception {

        LOG.info("insert a city");

        mockMvc.perform(MockMvcRequestBuilders.post("/city")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"杭州\", \"state\": \"浙江\", \"country\": \"中国\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * 为了观察数据库是否回滚
     */
    @Test
    public void test2_doNothind() {

    }

}