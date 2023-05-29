package dataaccesslayer;

import java.util.List;

import transferobjects.GradeDTO;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.CredentialsDTO;

/**
 * Implements the GradeDao interface and provides access to the grade data
 * source. Assignment 2 Class: CST8288 - Lab Section: 013
 *
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 *
 */
public class GradeDaoImpl implements GradeDao {

    private CredentialsDTO creds;

    /**
     * Constructor that sets the CredentialsDTO for the GradeDaoImpl.
     *
     * @param creds The CredentialsDTO to use for accessing the grade data
     * source.
     */
    public GradeDaoImpl(CredentialsDTO creds) {
        this.creds = creds;
    }

    /**
     * Retrieves a list of all grades in the database.
     *
     * @return a list of all GradeDTO objects in the database.
     */
    @Override
    public List<GradeDTO> getAllGrade() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<GradeDTO> Grades = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT student_StudentID, course_CourseCode, gradeCode FROM grade ORDER BY student_StudentID");
            rs = pstmt.executeQuery();
            Grades = new ArrayList<GradeDTO>();
            while (rs.next()) {
                GradeDTO grade = new GradeDTO();
                grade.setStudent_StudentID(new Integer(rs.getInt("student_StudentID")));
                grade.setCourse_CourseCode(rs.getString("course_CourseCode"));
                grade.setGradeCode(rs.getString("gradeCode"));
                Grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GradeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return Grades;
    }

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
    @Override
    public GradeDTO getGradeByStudentIdCourseCode(int studentId, String courseCode) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        GradeDTO grade = null;
        try {
            DataSource ds = new DataSource(creds);

            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT student_StudentID, course_CourseCode, gradeCode FROM grade WHERE student_StudentID = ? AND course_CourseCode = ?");
            pstmt.setInt(1, studentId);
            pstmt.setString(2, courseCode);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                grade = new GradeDTO();
                grade.setStudent_StudentID(rs.getInt("student_StudentID"));
                grade.setCourse_CourseCode(rs.getString("course_CourseCode"));
                grade.setGradeCode(rs.getString("gradeCode"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GradeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return grade;
    }

    /**
     * Adds a new grade to the database.
     *
     * @param grade the GradeDTO object to add.
     */
    @Override
    public void addGrade(GradeDTO grade) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();

            pstmt = con.prepareStatement(
                    "INSERT INTO \"grade\" (\"student_StudentID\", \"course_CourseCode\", \"gradeCode\") "
                    + "VALUES(?, ?, ?)");
            pstmt.setInt(1, grade.getStudent_StudentID());
            pstmt.setString(2, grade.getCourse_CourseCode());
            pstmt.setString(3, grade.getGradeCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GradeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
     * Updates an existing grade in the database.
     *
     * @param grade the GradeDTO object to update.
     */
    @Override
    public void updateGrade(GradeDTO grade) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "UPDATE \"grade\" SET \"GradeCode\" = ?, "
                    + " WHERE \"student_StudentID\" = ? AND \"course_CourseCode\" = ?");
            pstmt.setInt(2, grade.getStudent_StudentID());
            pstmt.setString(3, grade.getCourse_CourseCode());
            pstmt.setString(1, grade.getGradeCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GradeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
     * Deletes an existing grade from the database.
     *
     * @param grade the GradeDTO object to delete.
     */
    @Override
    public void deleteGrade(GradeDTO grade) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "DELETE FROM \"grade\" WHERE \"student_StudentID\" = ? and \"course_CourseCode\" = ?");
            pstmt.setInt(1, grade.getStudent_StudentID().intValue());
            pstmt.setString(2, grade.getCourse_CourseCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GradeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
