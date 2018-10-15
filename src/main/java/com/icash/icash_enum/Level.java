package com.icash.icash_enum;

public enum Level {
    LV_1(
            1
    ),
    LV_2(
            2
    ),
    LV_3(
            3
    ),
    LV_4(
            4
    );
    private int value;

    private Level(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
