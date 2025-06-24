import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String user = request.getParameter("username");
    String pass = request.getParameter("password");
  
    try {
      Connection con = DBConnection.getConnection();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE email=? AND password=?");
      ps.setString(1, user);
      ps.setString(2, pass);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        response.sendRedirect("dashboard.jsp");
      } else {
        response.getWriter().println("Invalid login. Try again.");
      }

      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}