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

/**
 *
 * The StudentDaoImpl class implements the StudentDao interface and provides
 * access to the StudentDTO objects stored in the database. It uses a DataSource
 * object to create a connection to the database using the credentials passed in
 * the constructor. * Assignment 2 Class: CST8288 - Lab Section: 013
 *
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 */
public class StudentDaoImpl implements StudentDao {

    private CredentialsDTO creds;

    /**
     * Constructs a StudentDaoImpl object with the given credentials.
     *
     * @param creds the credentials to use to connect to the database
     */
    public StudentDaoImpl(CredentialsDTO creds) {
        this.creds = creds;
    }

    /**
     * Returns a list of all the students in the database.
     *
     * @return a list of all the students in the database
     */
    @Override
    public List<StudentDTO> getAllStudent() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<StudentDTO> Students = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT StudentID, firstName, lastName FROM Student ORDER BY StudentID");
            rs = pstmt.executeQuery();
            Students = new ArrayList<StudentDTO>();
            while (rs.next()) {
                StudentDTO Student = new StudentDTO();
                Student.setStudentID(new Integer(rs.getInt("StudentID")));
                Student.setFirstName(rs.getString("firstName"));
                Student.setLastName(rs.getString("lastName"));
                Students.add(Student);
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
        return Students;
    }

    /**
     * Returns the student with the given first name and last name.
     *
     * @param firstName the first name of the student to retrieve
     * @param lastName the last name of the student to retrieve
     * @return the student with the given first name and last name
     */
    @Override
    public StudentDTO getStudentByStudentName(String firstName, String lastName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StudentDTO Student = null;
        try {
            DataSource ds = new DataSource(creds);

            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT StudentID, firstName, lastName FROM Student WHERE firstName = ? AND lastName = ?");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Student = new StudentDTO();
                Student.setStudentID(rs.getInt("StudentID"));
                Student.setFirstName(rs.getString("firstName"));
                Student.setLastName(rs.getString("lastName"));

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
        return Student;
    }

    /**
     * Adds a student to the data store.
     *
     * @param student the StudentDTO object to add
     */
    @Override
    public void addStudent(StudentDTO Student) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            // do not insert StudentID, it is generated by Database
            pstmt = con.prepareStatement(
                    "INSERT INTO \"Student\" (\"firstName\", \"lastName\") "
                    + "VALUES(?, ?)");
            pstmt.setString(1, Student.getFirstName());
            pstmt.setString(2, Student.getLastName());
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
     * Updates a student in the data store.
     *
     * @param student the StudentDTO object to update
     */
    @Override
    public void updateStudent(StudentDTO Student) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "UPDATE \"Student\" SET \"firstName\" = ?, "
                    + "\"lastName\" = ? WHERE \"StudentID\" = ?");
            pstmt.setString(1, Student.getFirstName());
            pstmt.setString(2, Student.getLastName());
            pstmt.setInt(3, Student.getStudentID().intValue());
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
     * Deletes a student from the data store.
     *
     * @param student the StudentDTO object to delete
     */
    @Override
    public void deleteStudent(StudentDTO Student) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "DELETE FROM \"Student\" WHERE \"StudentID\" = ?");
            pstmt.setInt(1, Student.getStudentID().intValue());
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
