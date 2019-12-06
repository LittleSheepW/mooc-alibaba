package com.ww.UnitTestConstructsTheCorrectPostureOfTheData21.entity.complex;

import java.util.StringJoiner;

public class Grade {

    private int grade;

    public Grade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Grade.class.getSimpleName() + "[", "]").add("grade=" + grade)
            .toString();
    }
}