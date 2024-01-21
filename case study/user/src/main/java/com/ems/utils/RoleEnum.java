package com.ems.utils;

public enum RoleEnum {
    USER("User"),
    ADMIN("Admin");

    private final String displayName;

    RoleEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}