// File: AddStudentServlet.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String course = request.getParameter("course");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement("INSERT INTO student (name, age, course) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.executeUpdate();

            con.close();
            response.getWriter().println("Student Added Successfully! <a href='dashboard.jsp'>Go Back</a>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

