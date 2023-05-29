package viewlayer;

import businesslayer.GradeBusinessLogic;
import businesslayer.StudentBusinessLogic;
import businesslayer.TutorCourseBusinessLogic;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslayer.*;
import java.util.ArrayList;
import transferobjects.TutorDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.CredentialsDTO;
import transferobjects.GradeDTO;
import transferobjects.StudentDTO;
import transferobjects.TutorCourseDTO;

/**
 * The TutorsSummaryView class is a servlet that retrieves and displays a list
 * of tutors assigned to a specific course for a given tutor name, provided that
 * the tutor has achieved a grade of A- or higher in the course. It first
 * retrieves the credentials of the user (username, password, first name, last
 * name, and course code), and then performs the following operations: Verifies
 * the user's credentials. Checks whether the user exists as a tutor. Retrieves
 * the user's grade in the course. Checks whether the user's grade is sufficient
 * to be a tutor. Adds the user to the list of tutors assigned to the course.
 * Displays the list of tutors assigned to the course.
 *
 * Assignment 2
 * Class: CST8288 - Lab Section: 013
 *
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 *
 */
public class TutorsSummaryView extends HttpServlet {

    /**
     * Credentials of the user (username, password, first name, last name, and
     * course code).
     */
    private CredentialsDTO creds = new CredentialsDTO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Tutors Summary View</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tutors Summary View at " + request.getContextPath() + "</h1>");

            creds.setUsername(request.getParameter("username"));
            creds.setPassword(request.getParameter("password"));
            creds.setFirstName(request.getParameter("firstName"));
            creds.setLastName(request.getParameter("lastName"));
            creds.setCourseCode(request.getParameter("courseCode"));

            TutorsBusinessLogic logic = new TutorsBusinessLogic(creds);
            List<TutorDTO> tutors = logic.getAllTutors();
            TutorDTO tutor2 = logic.getTutorByTutorName(creds.getFirstName(), creds.getLastName());
            if (!creds.getUsername().equals("CST8288") || !creds.getPassword().equals("CST8288")) {
                out.println("Wrong user name or password, please re-enter.");
            } else {
                //show info if the tutor doesn't exist

                if (tutor2 == null) {
                    out.println("<ul><li>First name: " + creds.getFirstName() + " </li>");
                    out.println("<li>Last name: " + creds.getLastName() + " </li></ul>");
                    out.println("<p> The person has not registered as a tutor.</p>");
                } //proceed to check the grade
                else if (tutor2 != null) {
                    StudentBusinessLogic logicStudent = new StudentBusinessLogic(creds);
                    List<StudentDTO> student = logicStudent.getAllStudent();
                    StudentDTO student2 = logicStudent.getStudentByStudentName(creds.getFirstName(), creds.getLastName());

                    GradeBusinessLogic logicGrade = new GradeBusinessLogic(creds);

                    List<GradeDTO> grade = logicGrade.getAllGrade();
                    GradeDTO grade2 = logicGrade.getGradeByStudentIdCourseCode(student2.getStudentID(), creds.getCourseCode());
                    String gradeCode = grade2.getGradeCode();
                    if (!gradeCode.equals("A-") && !gradeCode.equals("A") && !gradeCode.equals("A+")) {
                        out.println("<ul><li>First name: " + creds.getFirstName() + " </li>");
                        out.println("<li>Last name: " + creds.getLastName() + " </li></ul>");
                        out.println("<p> This person does not qualify to tutor this course as the obtained grade is not sufficient.</p>");
                    } else {

                        TutorCourseBusinessLogic logicTutorCourse = new TutorCourseBusinessLogic(creds);
                        TutorCourseDTO tutorCourse = new TutorCourseDTO();
                        tutorCourse.setTutor_tutorID(tutor2.getTutorID());
                        tutorCourse.setCourse_courseCode(creds.getCourseCode());

                        try {
                            logicTutorCourse.addTutorCourse(tutorCourse);
                        } catch (ValidationException ex) {
                            Logger.getLogger(TutorsSummaryView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        TutorCourseBusinessLogic logicGetNewTutors = new TutorCourseBusinessLogic(creds);
                        List<TutorCourseDTO> tutorCourses = logicTutorCourse.getAllTutorCourse();

                        out.println("<p>Table of tutors assigned to " + tutorCourse.getCourse_courseCode() + "</p>");
                        out.println("<table border=\"1\">");
                        out.println("<tr>");
                        out.println("<td>TutorID</td>");
                        out.println("<td>First Name</td>");
                        out.println("<td>Last Name</td>");
                        out.println("</tr>");
                        for (TutorCourseDTO tutorCourse2 : tutorCourses) {

                            TutorsBusinessLogic logic3 = new TutorsBusinessLogic(creds);
                            List<TutorDTO> tutors3 = logic.getAllTutors();
                            TutorDTO tutor4 = logic.getTutorByTutorId(tutorCourse2.getTutor_tutorID());
                            out.printf("<tr><td>%d</td><td>%s</td><td>%s</td></tr>",
                                    tutorCourse2.getTutor_tutorID(), tutor4.getFirstName(), tutor4.getLastName());
                        }
                        out.println("</table>");
                        out.println("</body>");
                        out.println("</html>");

                    }
                }
            }

        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
