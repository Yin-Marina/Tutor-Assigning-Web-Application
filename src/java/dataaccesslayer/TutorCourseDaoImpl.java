package dataaccesslayer;

import java.util.List;

import transferobjects.StudentDTO;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.CredentialsDTO;
import transferobjects.TutorCourseDTO;

/**
 * The TutorCourseDaoImpl class implements the TutorCourseDao interface,
 * providing methods for accessing and manipulating tutor-course relationship
 * data in a data source.
 *
 * This class is part of the CST8288 course project.
 *
 * Assignment: 2 Class: CST8288 Lab Section: 013 Lab Professor: Siju Philip
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 */
public class TutorCourseDaoImpl implements TutorCourseDao {

    private CredentialsDTO creds;

    /**
     * Constructs a TutorCourseDaoImpl object with the specified CredentialsDTO.
     *
     * @param creds the CredentialsDTO to be used for database access
     */
    public TutorCourseDaoImpl(CredentialsDTO creds) {
        this.creds = creds;
    }

    /**
     * Returns a List of all TutorCourseDTO objects in the data source.
     *
     * @return a List of all TutorCourseDTO objects
     */
    @Override
    public List<TutorCourseDTO> getAllTutorCourse() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<TutorCourseDTO> tutorCourses = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT tutor_TutorID, course_CourseCode FROM tutorCourse");
            rs = pstmt.executeQuery();
            tutorCourses = new ArrayList<TutorCourseDTO>();
            while (rs.next()) {
                TutorCourseDTO tutorCourse = new TutorCourseDTO();
                tutorCourse.setTutor_tutorID(new Integer(rs.getInt("tutor_tutorID")));
                tutorCourse.setCourse_courseCode(rs.getString("course_CourseCode"));
                tutorCourses.add(tutorCourse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TutorCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return tutorCourses;
    }

    /**
     * Returns a List of TutorCourseDTO objects in the data source that match
     * the specified course code.
     *
     * @param courseCode the course code to search for
     * @return a List of TutorCourseDTO objects that match the specified course
     * code
     */
    @Override
    public List<TutorCourseDTO> getTutorCourseByCourseCode(String courseCode) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<TutorCourseDTO> tutorCourses = null;
        try {
            DataSource ds = new DataSource(creds);

            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT tutor_tutorID, course_CourseCode FROM tutorCourse WHERE course_CourseCode = ?");
            pstmt.setString(1, courseCode);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                TutorCourseDTO tutorCourse = new TutorCourseDTO();
                tutorCourse.setTutor_tutorID(new Integer(rs.getInt("tutor_tutorID")));
                tutorCourse.setCourse_courseCode(rs.getString("course_CourseCode"));
                tutorCourses.add(tutorCourse);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return tutorCourses;
    }

    /**
     * Adds a TutorCourseDTO object to the data source.
     *
     * @param tutorCourse the TutorCourseDTO object to add
     */
    @Override
    public void addTutorCourse(TutorCourseDTO TutorCourse) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            // do not insert StudentID, it is generated by Database
            pstmt = con.prepareStatement(
                    "INSERT INTO TutorCourse (tutor_TutorID, course_CourseCode) "
                    + "VALUES(?, ?)");
            pstmt.setInt(1, TutorCourse.getTutor_tutorID());
            pstmt.setString(2, TutorCourse.getCourse_courseCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TutorCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Updates a TutorCourseDTO object in the data source.
     *
     * @param tutorCourse the TutorCourseDTO object to update
     */
    @Override
    public void updateTutorCourse(TutorCourseDTO TutorCourse) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "UPDATE \"TutorCourse\" SET \"tutor_TutorID\" = ?, "
                    + "\"course_CourseCode\" = ? WHERE \"tutor_TutorID\" = ?");
            pstmt.setInt(1, TutorCourse.getTutor_tutorID());
            pstmt.setString(2, TutorCourse.getCourse_courseCode());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Deletes a TutorCourseDTO object from the data source.
     *
     * @param tutorCourse the TutorCourseDTO object to delete
     */
    @Override
    public void deleteTutorCourse(TutorCourseDTO TutorCourse) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "DELETE FROM \"TutorCourse\" WHERE \"tutor_TutorID\" = ? AND \"course_CourseCode\" = ?");
            pstmt.setInt(1, TutorCourse.getTutor_tutorID().intValue());
            pstmt.setString(1, TutorCourse.getCourse_courseCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
