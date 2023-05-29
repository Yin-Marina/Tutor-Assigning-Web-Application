package dataaccesslayer;

import java.util.List;

import transferobjects.GradeDTO;

/**
 *
 * An interface for accessing and manipulating Grade data in the database.
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
public interface GradeDao {

    /**
     * Retrieves a list of all grades in the database.
     *
     * @return a list of all GradeDTO objects in the database.
     */
    List<GradeDTO> getAllGrade();

    /**
     * Retrieves a GradeDTO object from the database by student ID and course
     * code.
     *
     * @param studentId the ID of the student whose grade is being retrieved.
     * @param courseCode the code of the course for which the grade is being
     * retrieved.
     * @return a GradeDTO object for the specified student and course, or null
     * if no grade was found.
     */
    GradeDTO getGradeByStudentIdCourseCode(int studentId, String courseCode);

    /**
     * Adds a new grade to the database.
     *
     * @param grade the GradeDTO object to add.
     */
    void addGrade(GradeDTO grade);

    /**
     * Updates an existing grade in the database.
     *
     * @param grade the GradeDTO object to update.
     */
    void updateGrade(GradeDTO grade);

    /**
     * Deletes an existing grade from the database.
     *
     * @param grade the GradeDTO object to delete.
     */
    void deleteGrade(GradeDTO grade);
}
