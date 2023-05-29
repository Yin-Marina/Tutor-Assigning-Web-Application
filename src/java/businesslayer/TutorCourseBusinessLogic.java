package businesslayer;

import businesslayer.ValidationException;
import java.util.List;
import dataaccesslayer.TutorCourseDao;
import dataaccesslayer.TutorCourseDaoImpl;
import transferobjects.TutorCourseDTO;
import transferobjects.CredentialsDTO;

/**
 *
 * The TutorCourseBusinessLogic class is responsible for providing the business
 * logic related to tutor course operations such as retrieving, adding, updating
 * and deleting tutor courses from the data source. Assignment 2 Class: CST8288
 * - Lab Section: 013
 *
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 */
public class TutorCourseBusinessLogic {

    private static final int FIRST_NAME_MAX_LENGTH = 30;
    private static final int LAST_NAME_MAX_LENGTH = 30;

    private TutorCourseDao tutorCoursesDao = null;
    private CredentialsDTO creds;

    /**
     * Constructor for creating a new instance of the TutorCourseBusinessLogic
     * class
     *
     * @param creds the credentials required to access the data source
     */
    public TutorCourseBusinessLogic(CredentialsDTO creds) {
        tutorCoursesDao = new TutorCourseDaoImpl(creds);
    }

    /**
     * Retrieves all tutor courses from the data source
     *
     * @return a list of all tutor courses
     */
    public List<TutorCourseDTO> getAllTutorCourse() {
        return tutorCoursesDao.getAllTutorCourse();
    }

    /**
     * Retrieves all tutor courses with a given course code
     *
     * @param courseCode the code of the course to retrieve tutor courses for
     * @return a list of all tutor courses for the given course code
     */
    public List<TutorCourseDTO> getTutorCourseByCourseCode(String courseCode) {
        return tutorCoursesDao.getTutorCourseByCourseCode(courseCode);
    }

    /**
     * Adds a new tutor course to the data source
     *
     * @param tutorCourse the tutor course to add
     * @throws ValidationException if the tutor course data is not in a valid
     * format
     */
    public void addTutorCourse(TutorCourseDTO tutorCourse) throws ValidationException {

        tutorCoursesDao.addTutorCourse(tutorCourse);
    }

    /**
     * Updates an existing tutor course in the data source
     *
     * @param tutorCourse the tutor course to update
     * @throws ValidationException if the tutor course data is not in a valid
     * format
     */
    public void updateTutorCourse(TutorCourseDTO tutorCourse) throws ValidationException {

        tutorCoursesDao.updateTutorCourse(tutorCourse);
    }

    /**
     * Deletes a tutor course from the data source
     *
     * @param tutorCourse the tutor course to delete
     */
    public void deleteTutorCourse(TutorCourseDTO tutorCourse) {
        tutorCoursesDao.deleteTutorCourse(tutorCourse);
    }

}
