package dataaccesslayer;

import java.util.List;

import transferobjects.TutorCourseDTO;

/**
 *
 * This interface provides the methods for accessing and manipulating
 * tutor-course relationship data in a data source. 
 * Assignment 2 Class: CST8288
 * - Lab Section: 013
 *
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 */
public interface TutorCourseDao {

    /**
     * Returns a list of all TutorCourseDTO objects in the data source.
     *
     * @return a list of TutorCourseDTO objects
     */
    List<TutorCourseDTO> getAllTutorCourse();

    /**
     * Returns a list of TutorCourseDTO objects in the data source with a
     * specified course code.
     *
     * @param courseCode the course code to match
     * @return a list of TutorCourseDTO objects matching the course code
     */
    List<TutorCourseDTO> getTutorCourseByCourseCode(String courseCode);

    /**
     * Adds a TutorCourseDTO object to the data source.
     *
     * @param tutorCourse the TutorCourseDTO object to add
     */
    void addTutorCourse(TutorCourseDTO tutorCourse);

    /**
     * Updates a TutorCourseDTO object in the data source.
     *
     * @param tutorCourse the TutorCourseDTO object to update
     */
    void updateTutorCourse(TutorCourseDTO tutorCourse);

    /**
     * Deletes a TutorCourseDTO object from the data source.
     *
     * @param tutorCourse the TutorCourseDTO object to delete
     */
    void deleteTutorCourse(TutorCourseDTO tutorCourse);
}
