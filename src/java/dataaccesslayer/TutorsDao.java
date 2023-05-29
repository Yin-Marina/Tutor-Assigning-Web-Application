package dataaccesslayer;

import java.util.List;

import transferobjects.TutorDTO;

/**
 *
 * This interface represents the data access object for Tutors. It provides
 * methods to retrieve, add, update and delete Tutors. 
 * 
 * Assignment 2 Class:
 * CST8288 - Lab Section: 013
 *
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 */
public interface TutorsDao {

    /**
     * Retrieves a list of all Tutors from the database.
     *
     * @return A list of TutorDTO objects representing all Tutors in the
     * database.
     */
    List<TutorDTO> getAllTutors();

    /**
     * Retrieves a TutorDTO object with the given first and last name from the
     * database.
     *
     * @param firstName The first name of the Tutor to retrieve.
     * @param lastName The last name of the Tutor to retrieve.
     * @return A TutorDTO object representing the Tutor with the given first and
     * last name.
     */
    TutorDTO getTutorByTutorName(String firstName, String lastName);

    /**
     * Retrieves a TutorDTO object with the given ID from the database.
     *
     * @param tutorId The ID of the Tutor to retrieve.
     * @return A TutorDTO object representing the Tutor with the given ID.
     */
    TutorDTO getTutorByTutorId(int tutorId);

    /**
     * Adds a Tutor to the database.
     *
     * @param tutor The TutorDTO object representing the Tutor to add.
     */
    void addTutor(TutorDTO tutor);

    /**
     * Updates a Tutor in the database.
     *
     * @param tutor The TutorDTO object representing the Tutor to update.
     */
    void updateTutor(TutorDTO tutor);

    /**
     * Deletes a Tutor from the database.
     *
     * @param tutor The TutorDTO object representing the Tutor to delete.
     */
    void deleteTutor(TutorDTO tutor);
}
