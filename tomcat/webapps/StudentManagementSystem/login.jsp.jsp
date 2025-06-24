<%@ page language="java" %>
<html>
<head><title>Login</title></head>
<body>
<h2>Admin Login</h2>
<form action="LoginServlet" method="post">
  <input type="text" name="username" placeholder="Email">
  <input type="password" name="password" placeholder="Password">
  <input type="submit" value="Login">
</form>
</body>
</html>
