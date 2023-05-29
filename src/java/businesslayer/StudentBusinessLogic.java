package businesslayer;

import java.util.List;
import dataaccesslayer.StudentDao;
import dataaccesslayer.StudentDaoImpl;
import transferobjects.StudentDTO;
import transferobjects.CredentialsDTO;

/**
 *
 * The StudentBusinessLogic class provides business logic methods for the
 * Student object. It interacts with the data access layer to perform CRUD
 * operations on StudentDTO objects. Assignment 2 Class: CST8288 - Lab Section:
 * 013
 *
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 */
public class StudentBusinessLogic {

    private static final int FIRST_NAME_MAX_LENGTH = 30;
    private static final int LAST_NAME_MAX_LENGTH = 30;

    private StudentDao studentsDao = null;
    private CredentialsDTO creds;

/**
 * Constructs a new StudentBusinessLogic object with the specified CredentialsDTO.
 *
 * @param creds the credentials used to authenticate with the data access layer
 */
    public StudentBusinessLogic(CredentialsDTO creds) {
        studentsDao = new StudentDaoImpl(creds);
    }
/**
 * Returns a List of all StudentDTO objects in the data store.
 *
 * @return a List of all StudentDTO objects
 */
    public List<StudentDTO> getAllStudent() {
        return studentsDao.getAllStudent();
    }

 /**
 * Returns the StudentDTO object with the specified first and last name.
 *
 * @param firstName the first name of the student to retrieve
 * @param lastName the last name of the student to retrieve
 * @return the StudentDTO object with the specified first and last name
 */
    public StudentDTO getStudentByStudentName(String firstName, String lastName) {
        return studentsDao.getStudentByStudentName(firstName, lastName);
    }
/**
 * Adds a new StudentDTO object to the data store.
 *
 * @param student the StudentDTO object to add
 * @throws ValidationException if the StudentDTO object is invalid
 */
    public void addStudent(StudentDTO student) throws ValidationException {
        cleanStudent(student);
        validateStudent(student);
        studentsDao.addStudent(student);
    }
/**
 * Updates an existing StudentDTO object in the data store.
 *
 * @param student the StudentDTO object to update
 * @throws ValidationException if the StudentDTO object is invalid
 */
    public void updateStudent(StudentDTO student) throws ValidationException {
        cleanStudent(student);
        validateStudent(student);
        studentsDao.updateStudent(student);
    }

/**
 * Deletes an existing StudentDTO object from the data store.
 *
 * @param student the StudentDTO object to delete
 */
    public void deleteStudent(StudentDTO student) {
        studentsDao.deleteStudent(student);
    }
/**
 * Trims whitespace from the first and last name fields of a StudentDTO object.
 *
 * @param student the StudentDTO object to clean
 */
    private void cleanStudent(StudentDTO student) {
        if (student.getFirstName() != null) {
            student.setFirstName(student.getFirstName().trim());
        }
        if (student.getLastName() != null) {
            student.setLastName(student.getLastName().trim());
        }
    }
/**
 * Validates a StudentDTO object's first and last name fields.
 *
 * @param student the StudentDTO object to validate
 * @throws ValidationException if the StudentDTO object is invalid
 */
    private void validateStudent(StudentDTO student) throws ValidationException {
        validateString(student.getFirstName(), "First Name", FIRST_NAME_MAX_LENGTH, true);
        validateString(student.getLastName(), "Last Name", LAST_NAME_MAX_LENGTH, true);
    }
    /**
     *
     * Validates a given string based on several criteria: If the value is null
     * and null is allowed, then no validation is performed. If the value is
     * null and null is not allowed, a ValidationException is thrown with an
     * appropriate error message. If the value is an empty string or consists of
     * only whitespace, a ValidationException is thrown with an appropriate
     * error message. If the value exceeds the maximum length, a
     * ValidationException is thrown with an appropriate error message.
     *
     * @param value the string to be validated
     * @param fieldName the name of the field being validated
     * @param maxLength the maximum length allowed for the string
     * @param isNullAllowed a boolean indicating whether null values are allowed
     * for the string
     * @throws ValidationException if the string does not meet the specified
     * criteria
     */
    private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
            throws ValidationException {
        if (value == null && isNullAllowed) {
            // return; // null permitted, nothing to validate
        } else if (value == null && !isNullAllowed) {
            throw new ValidationException(String.format("%s cannot be null",
                    fieldName));
        } else if (value.length() == 0) {
            throw new ValidationException(String.format("%s cannot be empty or only whitespace",
                    fieldName));
        } else if (value.length() > maxLength) {
            throw new ValidationException(String.format("%s cannot exceed %d characters",
                    fieldName, maxLength));
        }
    }

}
