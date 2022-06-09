package com.deliveroo.solution.models;

public enum TIME_FIELD {
    MIN ("minute"),
    HOUR("hour"),
    DAY ("day of month"),
    MONTH ("month"),
    DAY_OF_WEEK("day of week");

    private final String name;
    private TIME_FIELD(String name_) {
        name = name_;
    }
    public String toString() {
        return this.name;
    }
}
