package transferobjects;

/**
 *
 * The TutorCourseDTO class represents the data transfer object for the
 * relationship between a tutor and a course.
 *
 * It contains the IDs of the tutor and the course they are assigned to.
 *
 * Assignment 2 Class: CST8288 - Lab Section: 013
 *
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 */
public class TutorCourseDTO {

    /**
     *
     * The ID of the tutor assigned to the course.
     */
    private Integer tutor_tutorID;
    /**
     *
     * The course code of the course assigned to the tutor.
     */
    private String course_courseCode;

    /**
     *
     * Returns the ID of the tutor assigned to the course.
     *
     * @return the ID of the tutor as an Integer.
     */
    public Integer getTutor_tutorID() {
        return tutor_tutorID;
    }

    /**
     *
     * Sets the ID of the tutor assigned to the course.
     *
     * @param tutor_tutorID the ID of the tutor as an Integer.
     */
    public void setTutor_tutorID(Integer tutor_tutorID) {
        this.tutor_tutorID = tutor_tutorID;
    }

    /**
     *
     * Returns the course code of the course assigned to the tutor.
     *
     * @return the course code as a String.
     */
    public String getCourse_courseCode() {
        return course_courseCode;
    }

    /**
     *
     * Sets the course code of the course assigned to the tutor.
     *
     * @param course_courseCode the course code as a String.
     */
    public void setCourse_courseCode(String course_courseCode) {
        this.course_courseCode = course_courseCode;
    }

}
