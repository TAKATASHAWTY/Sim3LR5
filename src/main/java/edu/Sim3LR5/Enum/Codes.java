package edu.Sim3LR5.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Codes {
    SUCCESS("success"),
    FAILED("failed");

    private final String name;

    Codes(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
