import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DeleteStudentServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));

    try {
      Connection con = DBConnection.getConnection();
      PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE id=?");
      ps.setInt(1, id);
      int i = ps.executeUpdate();

      if (i > 0) {
        response.getWriter().println("Student Deleted Successfully! <a href='UpdateStudentServlet'>Back</a>");
      } else {
        response.getWriter().println("Student Not Found.");
      }

      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}