package dataaccesslayer;

import java.util.List;
import transferobjects.StudentDTO;

/**
 *
 * An interface defining the operations that can be performed on the student
 * data in the data access layer. * Assignment 2 Class: CST8288 - Lab Section:
 * 013
 *
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 */
public interface StudentDao {

    /**
     * Returns a list of all students.
     *
     * @return a list of StudentDTO objects representing all students
     */
    List<StudentDTO> getAllStudent();

    /**
     * Returns a student by their first and last name.
     *
     * @param firstName the first name of the student to retrieve
     * @param lastName the last name of the student to retrieve
     * @return a StudentDTO object representing the retrieved student
     */
    StudentDTO getStudentByStudentName(String firstName, String lastName);

    /**
     * Adds a student to the data store.
     *
     * @param student the StudentDTO object to add
     */
    void addStudent(StudentDTO student);

    /**
     * Updates a student in the data store.
     *
     * @param student the StudentDTO object to update
     */
    void updateStudent(StudentDTO student);

    /**
     * Deletes a student from the data store.
     *
     * @param student the StudentDTO object to delete
     */
    void deleteStudent(StudentDTO student);
}
