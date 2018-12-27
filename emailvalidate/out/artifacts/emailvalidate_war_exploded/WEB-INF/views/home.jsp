<%--
  Created by IntelliJ IDEA.
  User: lycifer
  Date: 27/12/2018
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Email Validate</h1>

<h3 style="color:red">${message}</h3>



<form action="/validate" method="post">

    <label>
        <input type="text" name="email">
    </label><br>

    <input type="submit" value="Validate">

</form>
</body>
</html>
