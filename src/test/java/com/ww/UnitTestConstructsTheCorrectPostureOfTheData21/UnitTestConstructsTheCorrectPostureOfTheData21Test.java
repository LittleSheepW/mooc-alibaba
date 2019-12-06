package com.ww.UnitTestConstructsTheCorrectPostureOfTheData21;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Color;
import com.github.javafaker.Faker;
import com.github.javafaker.University;
import com.ww.UnitTestConstructsTheCorrectPostureOfTheData21.entity.complex.Employee;
import com.ww.UnitTestConstructsTheCorrectPostureOfTheData21.entity.complex.YearQuarter;
import com.ww.UnitTestConstructsTheCorrectPostureOfTheData21.entity.randomizer.YearQuarterRandomizer;
import com.ww.UnitTestConstructsTheCorrectPostureOfTheData21.entity.simple.Person;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.jeasy.random.TypePredicates;
import org.junit.Test;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @author: Sun
 * @create: 2019-12-06 11:34
 * @version: v1.0
 */
@Slf4j
public class UnitTestConstructsTheCorrectPostureOfTheData21Test {

    // ---------------------------------------------Java-faker---------------------------------------------------- //

    @Test
    public void useJavaFaker() {
        // 指定语言
        Faker faker = new Faker(new Locale("zh-CN"));

        // 姓名
        String name = faker.name().fullName();
        log.info(name);
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        log.info(lastName + " " + firstName);
        // 街道
        String streetAddress = faker.address().streetAddress();
        log.info(streetAddress);

        // 颜色
        Color color = faker.color();
        log.info(color.name() + "-->" + color.hex());

        // 大学
        University university = faker.university();
        log.info(university.name() + "-->" + university.prefix() + ":" + university.suffix());
    }


    // ----------------------------------------EasyRandom----------------------------------------------------- //

    private EasyRandom easyRandom = new EasyRandom();
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 随机生成单个简单对象
     *
     * @throws JsonProcessingException
     */
    @Test
    public void useEasyRandomBuildSimpleObject() throws JsonProcessingException {
        Person person = easyRandom.nextObject(Person.class);
        log.info("[useEasyRandom] [entity:{}] [json:{}]", person, objectMapper.writeValueAsString(person));
    }

    /**
     * 随机生成对象集合
     *
     * @throws JsonProcessingException
     */
    @Test
    public void useEasyRandomBuildObjectCollection() throws JsonProcessingException {
        List<Person> personList = easyRandom.objects(Person.class, 5)
                .collect(Collectors.toList());
        log.info("[useEasyRandomBuildObjectCollection] [randomEntityList:{}] [json:{}]", personList,
                objectMapper.writeValueAsString(personList));
    }

    /**
     * 复杂对象的生成
     */
    @Test
    public void useEasyRandomBuildComplexObject() {
        Employee employee = easyRandom.nextObject(Employee.class);
        log.info("[useEasyRandomBuildComplexObject] [此处打断点查看对象属性]");
    }

    /**
     * 使用配置优化所生成的对象
     */
    @Test
    public void useEasyRandomParameterBuildComplexObject() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.stringLengthRange(3, 3);
        parameters.collectionSizeRange(5, 5);
        parameters.excludeField(FieldPredicates.named("lastName").and(FieldPredicates.inClass(Employee.class)));
        parameters.excludeType(TypePredicates.inPackage("not.existing.pkg"));
        parameters.randomize(YearQuarter.class, new YearQuarterRandomizer());

        EasyRandom generator = new EasyRandom(parameters);
        Employee employee = generator.nextObject(Employee.class);

        assertEquals(3, employee.getFirstName().length());
        assertEquals(5, employee.getCoworkers().size());
        assertEquals(5, employee.getQuarterGrades().size());
        assertNotNull(employee.getDepartment());
        assertNull(employee.getLastName());

        for (YearQuarter key : employee.getQuarterGrades().keySet()) {
            assertEquals(key.getStartDate(), key.getEndDate().minusMonths(3L));
        }
    }
}