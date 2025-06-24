import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UpdateStudentListServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");

    try {
      PrintWriter out = response.getWriter();
      Connection con = DBConnection.getConnection();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM student");

      out.println("<h2>Student Records</h2>");
      out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Age</th><th>Course</th><th>Action</th></tr>");

      while (rs.next()) {
        int id = rs.getInt("id");
        out.println("<tr><td>" + id + "</td><td>" +
          rs.getString("name") + "</td><td>" +
          rs.getInt("age") + "</td><td>" +
          rs.getString("course") + "</td><td>" +
          "<a href='updateStudent.jsp?id=" + id + "'>Edit</a> | " +
          "<a href='DeleteStudentServlet?id=" + id + "'>Delete</a></td></tr>");
      }

      out.println("</table><br><a href='dashboard.jsp'>Back to Dashboard</a>");
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
