package businesslayer;

import java.util.List;
import dataaccesslayer.GradeDao;
import dataaccesslayer.GradeDaoImpl;
import transferobjects.GradeDTO;
import transferobjects.CredentialsDTO;

/**
 *
 * This class provides business logic for managing grade data in the system.
 * Assignment 2 Class: CST8288 - Lab Section: 013
 *
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 */
public class GradeBusinessLogic {

    private static final int FIRST_NAME_MAX_LENGTH = 30;
    private static final int LAST_NAME_MAX_LENGTH = 30;

    private GradeDao gradesDao = null;
    private CredentialsDTO creds;

    /**
     * Constructs a new instance of the {@link GradeBusinessLogic} class with
     * the specified credentials.
     *
     * @param creds the credentials used to connect to the data source
     */
    public GradeBusinessLogic(CredentialsDTO creds) {
        gradesDao = new GradeDaoImpl(creds);
    }

    /**
     * Returns a list of all grades stored in the system.
     *
     * @return a list of all grades stored in the system
     */
    public List<GradeDTO> getAllGrade() {
        return gradesDao.getAllGrade();
    }

    /**
     * Returns the grade of the specified student in the specified course.
     *
     * @param studentId the ID of the student whose grade to retrieve
     * @param courseCode the code of the course for which to retrieve the grade
     * @return the grade of the specified student in the specified course
     */
    public GradeDTO getGradeByStudentIdCourseCode(int studentId, String courseCode) {
        return gradesDao.getGradeByStudentIdCourseCode(studentId, courseCode);
    }

    /**
     * Adds a new grade to the system.
     *
     * @param grade the grade to add to the system
     * @throws ValidationException if the grade is invalid or cannot be added
     */
    public void addGrade(GradeDTO grade) throws ValidationException {

        gradesDao.addGrade(grade);
    }

    /**
     * Updates an existing grade in the system.
     *
     * @param grade the grade to update in the system
     * @throws ValidationException if the updated grade is invalid or cannot be
     * updated
     */
    public void updateGrade(GradeDTO grade) throws ValidationException {

        gradesDao.updateGrade(grade);
    }

    /**
     * Deletes a grade from the system.
     *
     * @param grade the grade to delete from the system
     */
    public void deleteGrade(GradeDTO grade) {
        gradesDao.deleteGrade(grade);
    }

}
