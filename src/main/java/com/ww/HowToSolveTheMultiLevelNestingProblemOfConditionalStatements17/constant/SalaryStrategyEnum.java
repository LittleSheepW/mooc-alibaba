package com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.constant;

public enum SalaryStrategyEnum {

    BOSS(0) {
        @Override
        public double getSalary() {
            return 100000;
        }
    },
    LEADER(1) {
        @Override
        public double getSalary() {
            return 50000;
        }
    },
    STAFF(2) {
        @Override
        public double getSalary() {
            return 10000;
        }
    };

    public final int position;

    // construct method.
    SalaryStrategyEnum(int position) {
        this.position = position;
    }

    // getSalary() abstract method.
    public abstract double getSalary();

    // Get Enum by position.
    public static SalaryStrategyEnum valueOf(int position) {
        for (SalaryStrategyEnum salaryStrategyEnum : SalaryStrategyEnum.values()) {
            if (salaryStrategyEnum.position == position) {
                return salaryStrategyEnum;
            }
        }
        return null;
    }
}