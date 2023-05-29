package transferobjects;

/**
 *
 * The CredentialsDTO class represents user credentials for authentication. It
 * includes the username and password for the user, as well as their first and
 * last name, and course code. This class contains getter and setter methods for
 * all of its attributes. Assignment 2 Class: CST8288 - Lab Section: 013
 *
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 */
public class CredentialsDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String courseCode;

    /**
     * simple getter for user name portion of the credentials
     *
     * @return user name portion of the credentials
     */
    public String getUsername() {
        return username;
    }

    /**
     * simple setter for user name portion of the credentials
     *
     * @param username user name portion of the credentials
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * simple getter for password portion of the credentials
     *
     * @return password portion of the credentials
     */
    public String getPassword() {
        return password;
    }

    /**
     * simple setter for password portion of the credentials
     *
     * @param password password portion of the credentials
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * simple getter for first name portion of the credentials
     *
     * @return first name portion of the credentials
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * simple setter for first name portion of the credentials
     *
     * @param firstName first name portion of the credentials
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * simple getter for last name portion of the credentials
     *
     * @return last name portion of the credentials
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * simple setter for last name portion of the credentials
     *
     * @param lastName last name portion of the credentials
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * simple getter for course code portion of the credentials
     *
     * @return course code portion of the credentials
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * simple setter for course code portion of the credentials
     *
     * @param courseCode course code portion of the credentials
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

}//class
