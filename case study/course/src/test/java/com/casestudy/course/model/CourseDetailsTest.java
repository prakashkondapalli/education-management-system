package com.casestudy.course.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CourseDetailsTest {
    /**
     * Method under test: {@link CourseDetails#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new CourseDetails("CSE", "Schedule", "Computer Science Engineering"))
                .canEqual("Other"));
    }

    /**
     * Method under test: {@link CourseDetails#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        CourseDetails courseDetails = new CourseDetails("CSE", "Schedule",
                "Computer Science Engineering");
        assertTrue(courseDetails
                .canEqual(new CourseDetails("CSE", "Schedule", "Computer Science Engineering")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CourseDetails#CourseDetails()}
     *   <li>{@link CourseDetails#setCourseName(String)}
     *   <li>{@link CourseDetails#setDescription(String)}
     *   <li>{@link CourseDetails#setSchedule(String)}
     *   <li>{@link CourseDetails#toString()}
     *   <li>{@link CourseDetails#getCourseName()}
     *   <li>{@link CourseDetails#getDescription()}
     *   <li>{@link CourseDetails#getSchedule()}
     * </ul>
     */
    @Test
    void testConstructor() {
        CourseDetails actualCourseDetails = new CourseDetails();
        actualCourseDetails.setCourseName("CSE");
        actualCourseDetails.setDescription("Computer Science Engineering");
        actualCourseDetails.setSchedule("Schedule");
        String actualToStringResult = actualCourseDetails.toString();
        assertEquals("CSE", actualCourseDetails.getCourseName());
        assertEquals("Computer Science Engineering", actualCourseDetails.getDescription());
        assertEquals("Schedule", actualCourseDetails.getSchedule());
        assertEquals("CourseDetails(courseName=CSE, schedule=Schedule, description=Computer Science"
                + " Engineering)", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CourseDetails#CourseDetails(String, String, String)}
     *   <li>{@link CourseDetails#setCourseName(String)}
     *   <li>{@link CourseDetails#setDescription(String)}
     *   <li>{@link CourseDetails#setSchedule(String)}
     *   <li>{@link CourseDetails#toString()}
     *   <li>{@link CourseDetails#getCourseName()}
     *   <li>{@link CourseDetails#getDescription()}
     *   <li>{@link CourseDetails#getSchedule()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        CourseDetails actualCourseDetails = new CourseDetails("CSE", "Schedule",
                "Computer Science Engineering");
        actualCourseDetails.setCourseName("CSE");
        actualCourseDetails.setDescription("Computer Science Engineering");
        actualCourseDetails.setSchedule("Schedule");
        String actualToStringResult = actualCourseDetails.toString();
        assertEquals("CSE", actualCourseDetails.getCourseName());
        assertEquals("Computer Science Engineering", actualCourseDetails.getDescription());
        assertEquals("Schedule", actualCourseDetails.getSchedule());
        assertEquals("CourseDetails(courseName=CSE, schedule=Schedule, description=Computer Science"
                + " Engineering)", actualToStringResult);
    }

    /**
     * Method under test: {@link CourseDetails#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new CourseDetails("CSE", "Schedule", "Computer Science Engineering"),
                null);
        assertNotEquals(new CourseDetails("CSE", "Schedule", "Computer Science Engineering"),
                "Different type to CourseDetails");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CourseDetails#equals(Object)}
     *   <li>{@link CourseDetails#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        CourseDetails courseDetails = new CourseDetails("CSE", "Schedule",
                "Computer Science Engineering");
        assertEquals(courseDetails, courseDetails);
        int expectedHashCodeResult = courseDetails.hashCode();
        assertEquals(expectedHashCodeResult, courseDetails.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CourseDetails#equals(Object)}
     *   <li>{@link CourseDetails#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        CourseDetails courseDetails = new CourseDetails("CSE", "Schedule",
                "Computer Science Engineering");
        CourseDetails courseDetails1 = new CourseDetails("CSE", "Schedule",
                "Computer Science Engineering");

        assertEquals(courseDetails, courseDetails1);
        int expectedHashCodeResult = courseDetails.hashCode();
        assertEquals(expectedHashCodeResult, courseDetails1.hashCode());
    }

    /**
     * Method under test: {@link CourseDetails#equals(Object)}
     */
    @Test
    void testEquals4() {
        CourseDetails courseDetails = new CourseDetails("Schedule", "Schedule",
                "Computer Science Engineering");
        assertNotEquals(courseDetails,
                new CourseDetails("CSE", "Schedule", "Computer Science Engineering"));
    }

    /**
     * Method under test: {@link CourseDetails#equals(Object)}
     */
    @Test
    void testEquals5() {
        CourseDetails courseDetails = new CourseDetails(null, "Schedule", "Computer Science Engineering");
        assertNotEquals(courseDetails,
                new CourseDetails("CSE", "Schedule", "Computer Science Engineering"));
    }

    /**
     * Method under test: {@link CourseDetails#equals(Object)}
     */
    @Test
    void testEquals6() {
        CourseDetails courseDetails = new CourseDetails("CSE", "CSE",
                "Computer Science Engineering");
        assertNotEquals(courseDetails,
                new CourseDetails("CSE", "Schedule", "Computer Science Engineering"));
    }

    /**
     * Method under test: {@link CourseDetails#equals(Object)}
     */
    @Test
    void testEquals7() {
        CourseDetails courseDetails = new CourseDetails("CSE", null,
                "Computer Science Engineering");
        assertNotEquals(courseDetails,
                new CourseDetails("CSE", "Schedule", "Computer Science Engineering"));
    }

    /**
     * Method under test: {@link CourseDetails#equals(Object)}
     */
    @Test
    void testEquals8() {
        CourseDetails courseDetails = new CourseDetails("CSE", "Schedule", "CSE");
        assertNotEquals(courseDetails,
                new CourseDetails("CSE", "Schedule", "Computer Science Engineering"));
    }

    /**
     * Method under test: {@link CourseDetails#equals(Object)}
     */
    @Test
    void testEquals9() {
        CourseDetails courseDetails = new CourseDetails("CSE", "Schedule", null);
        assertNotEquals(courseDetails,
                new CourseDetails("CSE", "Schedule", "Computer Science Engineering"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CourseDetails#equals(Object)}
     *   <li>{@link CourseDetails#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        CourseDetails courseDetails = new CourseDetails(null, "Schedule", "Computer Science Engineering");
        CourseDetails courseDetails1 = new CourseDetails(null, "Schedule", "Computer Science Engineering");

        assertEquals(courseDetails, courseDetails1);
        int expectedHashCodeResult = courseDetails.hashCode();
        assertEquals(expectedHashCodeResult, courseDetails1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CourseDetails#equals(Object)}
     *   <li>{@link CourseDetails#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        CourseDetails courseDetails = new CourseDetails("CSE", null,
                "Computer Science Engineering");
        CourseDetails courseDetails1 = new CourseDetails("CSE", null,
                "Computer Science Engineering");

        assertEquals(courseDetails, courseDetails1);
        int expectedHashCodeResult = courseDetails.hashCode();
        assertEquals(expectedHashCodeResult, courseDetails1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CourseDetails#equals(Object)}
     *   <li>{@link CourseDetails#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12() {
        CourseDetails courseDetails = new CourseDetails("CSE", "Schedule", null);
        CourseDetails courseDetails1 = new CourseDetails("CSE", "Schedule", null);

        assertEquals(courseDetails, courseDetails1);
        int expectedHashCodeResult = courseDetails.hashCode();
        assertEquals(expectedHashCodeResult, courseDetails1.hashCode());
    }
}

