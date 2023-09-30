<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Employee Details</title>
</head>
<body>
    <p>Name: <%= request.getAttribute("name") %></p>
    <p>Age: <%= request.getAttribute("age") %></p>
</body>
</html>