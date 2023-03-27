<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Form</title>
</head>
<body>
    <form method="post" action="/users">
        <div>
            <label for="userId">User ID</label>
            <input class="form-control" id="userId" name="userId" placeholder="User ID">
        </div>
        <div>
            <label for="name">User Name</label>
            <input class="form-control" id="name" name="name" placeholder="User Name">
        </div>
        <button type="submit">Join</button>
    </form>
</body>
</html>