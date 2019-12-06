package com.ww.UnitTestConstructsTheCorrectPostureOfTheData21.entity.complex;

import java.util.StringJoiner;

public class Department {
    private String depName;

    public Department(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Department.class.getSimpleName() + "[", "]").add("depName='" + depName + "'")
            .toString();
    }
}