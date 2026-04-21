<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Registration</title>
</head>
<body>
    <h2>Employee Registration Form</h2>
    <form action="register" method="post">
        Name: <input type="text" name="name" required><br><br>
        Email: <input type="email" name="email" required><br><br>
        Department: <input type="text" name="department" required><br><br>
        Salary: <input type="number" step="0.01" name="salary" required><br><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>