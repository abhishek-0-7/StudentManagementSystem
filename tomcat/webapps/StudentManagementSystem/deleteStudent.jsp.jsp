<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f7fa;
            padding: 40px;
        }

        h2 {
            color: #333;
        }

        form {
            background-color: #fff;
            padding: 20px;
            max-width: 400px;
            margin-top: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }

        input[type="number"] {
            padding: 10px;
            width: 95%;
            margin-bottom: 15px;
        }

        input[type="submit"] {
            background-color: #e74c3c;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
        }

        input[type="submit"]:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>
    <h2>Delete Student Record</h2>

    <form action="deleteStudent" method="post">
        <label for="id">Enter Student ID to Delete:</label><br>
        <input type="number" id="id" name="id" required><br>
        <input type="submit" value="Delete Student">
    </form>
</body>
</html>
