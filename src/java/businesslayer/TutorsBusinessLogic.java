package businesslayer;

import java.util.List;
import dataaccesslayer.TutorsDao;
import dataaccesslayer.TutorsDaoImpl;
import transferobjects.TutorDTO;
import transferobjects.CredentialsDTO;

/**
 *
 * The TutorsBusinessLogic class contains methods to manipulate tutor data and
 * validate input. Assignment 2 Class: CST8288 - Lab Section: 013
 *
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 *
 */
public class TutorsBusinessLogic {

    private static final int FIRST_NAME_MAX_LENGTH = 30;
    private static final int LAST_NAME_MAX_LENGTH = 30;

    private TutorsDao tutorsDao = null;
    private CredentialsDTO creds;

    /**
     *
     * Constructs a TutorsBusinessLogic object with the specified credentials.
     *
     * @param creds the credentials needed to connect to the database
     */
    public TutorsBusinessLogic(CredentialsDTO creds) {
        tutorsDao = new TutorsDaoImpl(creds);
    }

    /**
     *
     * Returns a list of all tutors in the database.
     *
     * @return a list of all tutors
     */
    public List<TutorDTO> getAllTutors() {
        return tutorsDao.getAllTutors();
    }

    /**
     *
     * Returns the tutor with the specified first name and last name.
     *
     * @param firstName the first name of the tutor
     * @param lastName the last name of the tutor
     * @return the tutor with the specified first name and last name
     */

    public TutorDTO getTutorByTutorName(String firstName, String lastName) {
        return tutorsDao.getTutorByTutorName(firstName, lastName);
    }

    /**
     *
     * Returns the tutor with the specified ID.
     *
     * @param tutorId the ID of the tutor
     * @return the tutor with the specified ID
     */
    public TutorDTO getTutorByTutorId(int tutorId) {
        return tutorsDao.getTutorByTutorId(tutorId);
    }

    /**
     *
     * Adds a new tutor to the database.
     *
     * @param tutor the tutor to be added
     * @throws ValidationException if the tutor data is invalid
     */
    public void addTutor(TutorDTO tutor) throws ValidationException {
        cleanTutor(tutor);
        validateTutor(tutor);
        tutorsDao.addTutor(tutor);
    }

    /**
     *
     * Updates an existing tutor in the database.
     *
     * @param tutor the tutor to be updated
     * @throws ValidationException if the tutor data is invalid
     */
    public void updateTutor(TutorDTO tutor) throws ValidationException {
        cleanTutor(tutor);
        validateTutor(tutor);
        tutorsDao.updateTutor(tutor);
    }

    /**
     *
     * Deletes a tutor from the database.
     *
     * @param tutor the tutor to be deleted
     */
    public void deleteTutor(TutorDTO tutor) {
        tutorsDao.deleteTutor(tutor);
    }

    /**
     *
     * Trims leading and trailing whitespace from the first and last names of a
     * tutor.
     *
     * @param tutor the tutor whose first and last names will be trimmed
     */
    private void cleanTutor(TutorDTO tutor) {
        if (tutor.getFirstName() != null) {
            tutor.setFirstName(tutor.getFirstName().trim());
        }
        if (tutor.getLastName() != null) {
            tutor.setLastName(tutor.getLastName().trim());
        }
    }

    /**
     *
     * Validates the first and last names of a tutor.
     *
     * @param tutor the tutor to be validated
     * @throws ValidationException if the first or last name is null, empty, or
     * too long
     */
    private void validateTutor(TutorDTO tutor) throws ValidationException {
        validateString(tutor.getFirstName(), "First Name", FIRST_NAME_MAX_LENGTH, true);
        validateString(tutor.getLastName(), "Last Name", LAST_NAME_MAX_LENGTH, true);
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
