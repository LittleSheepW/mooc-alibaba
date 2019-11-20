package com.ww.EnumerationClassCorrectLearningPosture10.constant;

/**
 * 枚举实现状态机
 * 假设业务开发中需要实现状态流转的功能
 * 申报-> 批准-> 报名 -> 开始 -> 结束
 */
public enum ActivityStatesEnum {

    DEACLARE(1) {
        @Override
        public ActivityStatesEnum nextState() {
            return APPROVE;
        }
    },
    APPROVE(2) {
        @Override
        public ActivityStatesEnum nextState() {
            return ENROLL;
        }
    },
    ENROLL(3) {
        @Override
        public ActivityStatesEnum nextState() {
            return START;
        }
    },
    START(4) {
        @Override
        public ActivityStatesEnum nextState() {
            return END;
        }
    },
    END(5) {
        @Override
        public ActivityStatesEnum nextState() {
            return this;
        }
    };

    private int status;

    public abstract ActivityStatesEnum nextState();

    // Construct method
    ActivityStatesEnum(int status) {
        this.status = status;
    }

    // 通过枚举值获得枚举常量
    public ActivityStatesEnum getEnum(int status) {
        for (ActivityStatesEnum statesEnum : ActivityStatesEnum.values()) {
            if (statesEnum.status == status) {
                return statesEnum;
            }
        }
        return null;
    }

    public int getStatus() {
        return status;
    }
}
