<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.*" %>
<%
    String id = request.getParameter("id");
    String name = "", course = "";
    int age = 0;

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "your_password");

        PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE id = ?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            name = rs.getString("name");
            age = rs.getInt("age");
            course = rs.getString("course");
        } else {
            out.println("<h3>⚠️ Student not found with ID " + id + "</h3>");
        }

        con.close();
    } catch (Exception e) {
        out.println("<p>Error: " + e.getMessage() + "</p>");
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f3;
            padding: 40px;
        }

        h2 {
            color: #333;
        }

        form {
            background-color: #fff;
            padding: 20px;
            max-width: 400px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }

        input[type="text"],
        input[type="number"] {
            width: 95%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #2980b9;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
        }

        input[type="submit"]:hover {
            background-color: #1c5f8e;
        }
    </style>
</head>
<body>
    <h2>Update Student Record</h2>

    <form action="UpdateStudentServlet" method="post">
        <input type="hidden" name="id" value="<%= id %>" />
        Name: <input type="text" name="name" value="<%= name %>" required /><br/>
        Age: <input type="number" name="age" value="<%= age %>" required /><br/>
        Course: <input type="text" name="course" value="<%= course %>" required /><br/>
        <input type="submit" value="Update Student" />
    </form>
</body>
</html>
