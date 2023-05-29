# Tutor Assigning web application

---

#Java #DesignPatterns #DAO #Servlet

This project incorporates the DAO pattern and Servlet pattern to achieve its goal of processing a web client's request to assign a course to a tutor.

The primary objective of this application is to assign a course to a qualified tutor. Here are the key features of the project:

The project involves creating a webpage that allows users to enter the necessary information, including user ID and password for database authentication, tutor's first name and last name, and the course code to be assigned.
Upon launching the servlet, it utilizes the DAO implementation to validate the data, assign the course to the tutor, and retrieve the required information.
In case the validation fails, the servlet responds with an appropriate error message.
On the other hand, if the validation is successful, the servlet returns a table displaying all the tutors assigned to the course, including the newly added tutor.
A tutor qualifies to teach the course if they are a tutor themselves and have previously completed the course with a grade of "A-", "A," or "A+".
To fulfill these requirements, the following steps need to be followed:

Develop a servlet that leverages the DAO implementation and generates the desired output based on the servlet request.
Provide a user-friendly web page to launch the servlet.
The initial web page should prompt the end-user to enter their user ID and password for MySQL database authentication, as well as the tutor's first name, last name, and the course code to be assigned.
The servlet will generate the HTML output as a response to the servlet request. This output will either be an appropriate error message in case of validation failure or a table displaying all the tutors assigned to the course, including the newly added tutor.