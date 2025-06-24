<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
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
            background-color: #27ae60;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
        }

        input[type="submit"]:hover {
            background-color: #219150;
        }
    </style>
</head>
<body>
    <h2>Add Student</h2>
    <form method="post" action="AddStudentServlet">
        Name: <input type="text" name="name" required /><br/>
        Age: <input type="number" name="age" required /><br/>
        Course: <input type="text" name="course" required /><br/>
        <input type="submit" value="Add Student" />
    </form>
</body>
</html>
