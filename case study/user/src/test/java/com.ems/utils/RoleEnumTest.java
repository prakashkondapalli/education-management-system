package com.ems.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RoleEnumTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RoleEnum#valueOf(String)}
     *   <li>{@link RoleEnum#getDisplayName()}
     * </ul>
     */
    @Test
    void testValueOf() {
        assertEquals("User", RoleEnum.valueOf("USER").getDisplayName());
    }
}

