package transferobjects;

/**
 *
 * The GradeDTO class represents the data transfer object for grades. It
 * contains the properties and methods to access and manipulate grade data.
 * Assignment 2 Class: CST8288 - Lab Section: 013
 *
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 */
public class GradeDTO {

    private Integer student_StudentID;
    private String course_CourseCode;
    private String gradeCode;

    /**
     * Gets the ID of the student associated with the grade.
     *
     * @return the student ID as an Integer
     */
    public Integer getStudent_StudentID() {
        return student_StudentID;
    }

    /**
     * Sets the ID of the student associated with the grade.
     *
     * @param student_StudentID the student ID as an Integer
     */
    public void setStudent_StudentID(Integer student_StudentID) {
        this.student_StudentID = student_StudentID;
    }

    /**
     * Gets the course code associated with the grade.
     *
     * @return the course code as a String
     */
    public String getCourse_CourseCode() {
        return course_CourseCode;
    }

    /**
     * Sets the course code associated with the grade.
     *
     * @param course_CourseCode the course code as a String
     */
    public void setCourse_CourseCode(String course_CourseCode) {
        this.course_CourseCode = course_CourseCode;
    }

    /**
     * Gets the grade code for the grade.
     *
     * @return the grade code as a String
     */
    public String getGradeCode() {
        return gradeCode;
    }

    /**
     * Sets the grade code for the grade.
     *
     * @param gradeCode the grade code as a String
     */
    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

}
