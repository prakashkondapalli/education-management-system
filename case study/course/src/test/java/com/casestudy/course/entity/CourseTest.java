package com.casestudy.course.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class CourseTest {
    /**
     * Method under test: {@link Course#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Course()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Course#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Course course = new Course();

        Course course1 = new Course();
        course1.setCourseName("CSE");
        course1.setCourseUuid(UUID.randomUUID());
        course1.setDescription("Computer Science Engineering");
        course1.setSchedule("Schedule");
        assertTrue(course.canEqual(course1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Course}
     *   <li>{@link Course#setCourseName(String)}
     *   <li>{@link Course#setCourseUuid(UUID)}
     *   <li>{@link Course#setDescription(String)}
     *   <li>{@link Course#setSchedule(String)}
     *   <li>{@link Course#toString()}
     *   <li>{@link Course#getCourseName()}
     *   <li>{@link Course#getCourseUuid()}
     *   <li>{@link Course#getDescription()}
     *   <li>{@link Course#getSchedule()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Course actualCourse = new Course();
        actualCourse.setCourseName("CSE");
        UUID randomUUIDResult = UUID.randomUUID();
        actualCourse.setCourseUuid(randomUUIDResult);
        actualCourse.setDescription("Computer Science Engineering");
        actualCourse.setSchedule("Schedule");
        actualCourse.toString();
        assertEquals("CSE", actualCourse.getCourseName());
        assertSame(randomUUIDResult, actualCourse.getCourseUuid());
        assertEquals("Computer Science Engineering", actualCourse.getDescription());
        assertEquals("Schedule", actualCourse.getSchedule());
    }

    /**
     * Method under test: {@link Course#equals(Object)}
     */
    @Test
    void testEquals() {
        Course course = new Course();
        course.setCourseName("CSE");
        course.setCourseUuid(UUID.randomUUID());
        course.setDescription("Computer Science Engineering");
        course.setSchedule("Schedule");
        assertNotEquals(course, null);
    }

    /**
     * Method under test: {@link Course#equals(Object)}
     */
    @Test
    void testEquals2() {
        Course course = new Course();
        course.setCourseName("CSE");
        course.setCourseUuid(UUID.randomUUID());
        course.setDescription("Computer Science Engineering");
        course.setSchedule("Schedule");
        assertNotEquals(course, "Different type to Course");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Course#equals(Object)}
     *   <li>{@link Course#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Course course = new Course();
        course.setCourseName("CSE");
        course.setCourseUuid(UUID.randomUUID());
        course.setDescription("Computer Science Engineering");
        course.setSchedule("Schedule");
        assertEquals(course, course);
        int expectedHashCodeResult = course.hashCode();
        assertEquals(expectedHashCodeResult, course.hashCode());
    }

    /**
     * Method under test: {@link Course#equals(Object)}
     */
    @Test
    void testEquals4() {
        Course course = new Course();
        course.setCourseName("CSE");
        course.setCourseUuid(UUID.randomUUID());
        course.setDescription("Computer Science Engineering");
        course.setSchedule("Schedule");

        Course course1 = new Course();
        course1.setCourseName("CSE");
        course1.setCourseUuid(UUID.randomUUID());
        course1.setDescription("Computer Science Engineering");
        course1.setSchedule("Schedule");
        assertNotEquals(course, course1);
    }

    /**
     * Method under test: {@link Course#equals(Object)}
     */
    @Test
    void testEquals5() {
        Course course = new Course();
        course.setCourseName("CSE");
        course.setCourseUuid(null);
        course.setDescription("Computer Science Engineering");
        course.setSchedule("Schedule");

        Course course1 = new Course();
        course1.setCourseName("CSE");
        course1.setCourseUuid(UUID.randomUUID());
        course1.setDescription("Computer Science Engineering");
        course1.setSchedule("Schedule");
        assertNotEquals(course, course1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Course#equals(Object)}
     *   <li>{@link Course#hashCode()}
     * </ul>
     */
    @Test
    void testEquals6() {
        Course course = new Course();
        course.setCourseName("CSE");
        course.setCourseUuid(null);
        course.setDescription("Computer Science Engineering");
        course.setSchedule("Schedule");

        Course course1 = new Course();
        course1.setCourseName("CSE");
        course1.setCourseUuid(null);
        course1.setDescription("Computer Science Engineering");
        course1.setSchedule("Schedule");
        assertEquals(course, course1);
        int expectedHashCodeResult = course.hashCode();
        assertEquals(expectedHashCodeResult, course1.hashCode());
    }

    /**
     * Method under test: {@link Course#equals(Object)}
     */
    @Test
    void testEquals7() {
        Course course = new Course();
        course.setCourseName("Schedule");
        course.setCourseUuid(null);
        course.setDescription("Computer Science Engineering");
        course.setSchedule("Schedule");

        Course course1 = new Course();
        course1.setCourseName("CSE");
        course1.setCourseUuid(null);
        course1.setDescription("Computer Science Engineering");
        course1.setSchedule("Schedule");
        assertNotEquals(course, course1);
    }

    /**
     * Method under test: {@link Course#equals(Object)}
     */
    @Test
    void testEquals8() {
        Course course = new Course();
        course.setCourseName(null);
        course.setCourseUuid(null);
        course.setDescription("Computer Science Engineering");
        course.setSchedule("Schedule");

        Course course1 = new Course();
        course1.setCourseName("CSE");
        course1.setCourseUuid(null);
        course1.setDescription("Computer Science Engineering");
        course1.setSchedule("Schedule");
        assertNotEquals(course, course1);
    }

    /**
     * Method under test: {@link Course#equals(Object)}
     */
    @Test
    void testEquals9() {
        Course course = new Course();
        course.setCourseName("CSE");
        course.setCourseUuid(null);
        course.setDescription("CSE");
        course.setSchedule("Schedule");

        Course course1 = new Course();
        course1.setCourseName("CSE");
        course1.setCourseUuid(null);
        course1.setDescription("Computer Science Engineering");
        course1.setSchedule("Schedule");
        assertNotEquals(course, course1);
    }

    /**
     * Method under test: {@link Course#equals(Object)}
     */
    @Test
    void testEquals10() {
        Course course = new Course();
        course.setCourseName("CSE");
        course.setCourseUuid(null);
        course.setDescription(null);
        course.setSchedule("Schedule");

        Course course1 = new Course();
        course1.setCourseName("CSE");
        course1.setCourseUuid(null);
        course1.setDescription("Computer Science Engineering");
        course1.setSchedule("Schedule");
        assertNotEquals(course, course1);
    }

    /**
     * Method under test: {@link Course#equals(Object)}
     */
    @Test
    void testEquals11() {
        Course course = new Course();
        course.setCourseName("CSE");
        course.setCourseUuid(null);
        course.setDescription("Computer Science Engineering");
        course.setSchedule("CSE");

        Course course1 = new Course();
        course1.setCourseName("CSE");
        course1.setCourseUuid(null);
        course1.setDescription("Computer Science Engineering");
        course1.setSchedule("Schedule");
        assertNotEquals(course, course1);
    }

    /**
     * Method under test: {@link Course#equals(Object)}
     */
    @Test
    void testEquals12() {
        Course course = new Course();
        course.setCourseName("CSE");
        course.setCourseUuid(null);
        course.setDescription("Computer Science Engineering");
        course.setSchedule(null);

        Course course1 = new Course();
        course1.setCourseName("CSE");
        course1.setCourseUuid(null);
        course1.setDescription("Computer Science Engineering");
        course1.setSchedule("Schedule");
        assertNotEquals(course, course1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Course#equals(Object)}
     *   <li>{@link Course#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13() {
        Course course = new Course();
        course.setCourseName(null);
        course.setCourseUuid(null);
        course.setDescription("Computer Science Engineering");
        course.setSchedule("Schedule");

        Course course1 = new Course();
        course1.setCourseName(null);
        course1.setCourseUuid(null);
        course1.setDescription("Computer Science Engineering");
        course1.setSchedule("Schedule");
        assertEquals(course, course1);
        int expectedHashCodeResult = course.hashCode();
        assertEquals(expectedHashCodeResult, course1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Course#equals(Object)}
     *   <li>{@link Course#hashCode()}
     * </ul>
     */
    @Test
    void testEquals14() {
        Course course = new Course();
        course.setCourseName("CSE");
        course.setCourseUuid(null);
        course.setDescription(null);
        course.setSchedule("Schedule");

        Course course1 = new Course();
        course1.setCourseName("CSE");
        course1.setCourseUuid(null);
        course1.setDescription(null);
        course1.setSchedule("Schedule");
        assertEquals(course, course1);
        int expectedHashCodeResult = course.hashCode();
        assertEquals(expectedHashCodeResult, course1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Course#equals(Object)}
     *   <li>{@link Course#hashCode()}
     * </ul>
     */
    @Test
    void testEquals15() {
        Course course = new Course();
        course.setCourseName("CSE");
        course.setCourseUuid(null);
        course.setDescription("Computer Science Engineering");
        course.setSchedule(null);

        Course course1 = new Course();
        course1.setCourseName("CSE");
        course1.setCourseUuid(null);
        course1.setDescription("Computer Science Engineering");
        course1.setSchedule(null);
        assertEquals(course, course1);
        int expectedHashCodeResult = course.hashCode();
        assertEquals(expectedHashCodeResult, course1.hashCode());
    }
}

