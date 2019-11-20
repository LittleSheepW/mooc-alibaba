package com.ww.EnumerationClassCorrectLearningPosture10.constant;

/**
 * 枚举类高级用法：
 * 枚举常量中可以带类方法
 */
public enum OperationEnum {
    PLUS {
        @Override
        public double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        public double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        @Override
        public double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDED_BY {
        @Override
        public double eval(double x, double y) {
            return x / y;
        }
    };

    // Each constant supports an arithmetic operation
    public abstract double eval(double x, double y);
}