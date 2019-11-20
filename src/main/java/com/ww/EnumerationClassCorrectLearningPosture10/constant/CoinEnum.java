package com.ww.EnumerationClassCorrectLearningPosture10.constant;

public enum CoinEnum {

    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    CoinEnum(int value) {
        this.value = value;
    }

    private final int value;

    public int value() {
        return value;
    }
}