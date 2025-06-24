import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UpdateStudentServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String course = request.getParameter("course");

    try {
      Connection con = DBConnection.getConnection();
      PreparedStatement ps = con.prepareStatement("UPDATE student SET name=?, age=?, course=? WHERE id=?");
      ps.setString(1, name);
      ps.setInt(2, age);
      ps.setString(3, course);
      ps.setInt(4, id);

      int rows = ps.executeUpdate();
      con.close();

      if (rows > 0) {
        response.getWriter().println("Student updated successfully! <a href='dashboard.jsp'>Go to Dashboard</a>");
      } else {
        response.getWriter().println("Update failed. Student not found.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
