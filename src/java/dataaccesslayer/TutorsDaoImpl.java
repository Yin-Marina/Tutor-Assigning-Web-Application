package dataaccesslayer;

import java.util.List;

import transferobjects.TutorDTO;

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
 * TutorsDaoImpl implements TutorsDao interface and provides implementation for
 * accessing Tutors table in database. It uses DataSource to create database
 * connection and implements CRUD operations for tutors.
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
public class TutorsDaoImpl implements TutorsDao {

    private CredentialsDTO creds;

    /**
     * Constructor initializes the credentials object which is used to connect
     * to the database.
     *
     * @param creds Credentials object with database connection details
     */
    public TutorsDaoImpl(CredentialsDTO creds) {
        this.creds = creds;
    }

    /**
     * Retrieves all tutors from the database and returns them as a list.
     *
     * @return ArrayList of TutorDTO objects containing all tutors in the
     * database
     */
    @Override
    public ArrayList<TutorDTO> getAllTutors() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<TutorDTO> tutors = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM tutor");
            rs = pstmt.executeQuery();
            tutors = new ArrayList<TutorDTO>();
            while (rs.next()) {
                TutorDTO tutor = new TutorDTO();
                tutor.setTutorID(new Integer(rs.getInt("tutorID")));
                tutor.setFirstName(rs.getString("firstName"));
                tutor.setLastName(rs.getString("lastName"));
                tutors.add(tutor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TutorsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return tutors;
    }

    /**
     * Retrieves a tutor from the database with the given first name and last
     * name.
     *
     * @param firstName First name of the tutor to retrieve
     * @param lastName Last name of the tutor to retrieve
     * @return TutorDTO object containing the details of the tutor
     */
    @Override
    public TutorDTO getTutorByTutorName(String firstName, String lastName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TutorDTO tutor = null;
        try {
            DataSource ds = new DataSource(creds);
            String fn = creds.getFirstName();
            String ln = creds.getLastName();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT tutorID, firstName, lastName FROM tutor WHERE firstName = ? AND lastName = ?");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                tutor = new TutorDTO();
                tutor.setTutorID(rs.getInt("tutorID"));
                tutor.setFirstName(rs.getString("firstName"));
                tutor.setLastName(rs.getString("lastName"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TutorsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return tutor;
    }

    /**
     *
     * Retrieves a TutorDTO object from the database by a given tutor ID.
     *
     * @param tutorId the ID of the tutor to retrieve
     * @return a TutorDTO object representing the tutor in the database
     */
    @Override
    public TutorDTO getTutorByTutorId(int tutorId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TutorDTO tutor = new TutorDTO();
        try {
            DataSource ds = new DataSource(creds);
            String fn = creds.getFirstName();
            String ln = creds.getLastName();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT tutorID, firstName, lastName FROM tutor WHERE tutorId = ? ");
            pstmt.setInt(1, tutorId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                tutor.setTutorID(rs.getInt("tutorID"));
                tutor.setFirstName(rs.getString("firstName"));
                tutor.setLastName(rs.getString("lastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TutorsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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

        return tutor;
    }

    /**
     *
     * Adds a TutorDTO object to the database.
     *
     * @param tutor the TutorDTO object to add to the database
     */
    @Override
    public void addTutor(TutorDTO tutor) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            // do not insert TutorID, it is generated by Database
            pstmt = con.prepareStatement(
                    "INSERT INTO \"tutor\" (\"firstName\", \"lastName\") "
                    + "VALUES(?, ?)");
            pstmt.setString(1, tutor.getFirstName());
            pstmt.setString(2, tutor.getLastName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TutorsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
     *
     * Updates a TutorDTO object in the database.
     *
     * @param tutor the TutorDTO object to update in the database
     */
    @Override
    public void updateTutor(TutorDTO tutor) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "UPDATE \"tutor\" SET \"firstName\" = ?, "
                    + "\"lastName\" = ? WHERE \"tutorID\" = ?");
            pstmt.setString(1, tutor.getFirstName());
            pstmt.setString(2, tutor.getLastName());
            pstmt.setInt(3, tutor.getTutorID().intValue());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TutorsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
     *
     * Updates a TutorDTO object in the database.
     *
     * @param tutor the TutorDTO object to update in the database
     */
    @Override
    public void deleteTutor(TutorDTO tutor) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "DELETE FROM \"tutor\" WHERE \"tutorID\" = ?");
            pstmt.setInt(1, tutor.getTutorID().intValue());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TutorsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
