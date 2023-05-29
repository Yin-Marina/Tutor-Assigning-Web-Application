package transferobjects;

/**
 *
 * Represents a Student Data Transfer Object (DTO) that contains information
 * about a student.
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
public class StudentDTO {

    private Integer studentID;// the ID of the student
    private String firstName;// the first name of the student
    private String lastName;// the last name of the student

    /**
     *
     * Returns the ID of the student.
     *
     * @return the ID of the student
     */
    public Integer getStudentID() {
        return studentID;
    }

    /**
     *
     * Sets the ID of the student.
     *
     * @param studentID the ID of the student to set
     */
    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    /**
     *
     * Returns the first name of the student.
     *
     * @return the first name of the student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * Sets the first name of the student.
     *
     * @param firstName the first name of the student to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * Returns the last name of the student.
     *
     * @return the last name of the student
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * Sets the last name of the student.
     *
     * @param lastName the last name of the student to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
