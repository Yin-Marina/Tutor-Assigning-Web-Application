package transferobjects;

/**
 * The TutorDTO class represents a Data Transfer Object (DTO) for a Tutor
 * entity. It encapsulates the tutor's ID, first name, and last name.
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
public class TutorDTO {

    /**
     * The tutor's ID.
     */
    private Integer tutorID;

    /**
     * The tutor's first name.
     */
    private String firstName;

    /**
     * The tutor's last name.
     */
    private String lastName;

    /**
     * Gets the tutor's ID.
     *
     * @return The tutor's ID.
     */
    public Integer getTutorID() {
        return tutorID;
    }

    /**
     * Sets the tutor's ID.
     *
     * @param tutorID The tutor's ID.
     */
    public void setTutorID(Integer tutorID) {
        this.tutorID = tutorID;
    }

    /**
     * Gets the tutor's first name.
     *
     * @return The tutor's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the tutor's first name.
     *
     * @param firstName The tutor's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the tutor's last name.
     *
     * @return The tutor's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the tutor's last name.
     *
     * @param lastName The tutor's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
