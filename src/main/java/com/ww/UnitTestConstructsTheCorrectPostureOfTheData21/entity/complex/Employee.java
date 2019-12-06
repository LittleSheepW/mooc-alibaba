package com.ww.UnitTestConstructsTheCorrectPostureOfTheData21.entity.complex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private Department department;
    private Collection<Employee> coworkers;
    private Map<YearQuarter, Grade> quarterGrades;
}