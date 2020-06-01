<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Save Condiments</title>
</head>
<body>
    <h1>${message}</h1>
    <h3>
        <c:forEach  var = "condiment" items="${condimentsArr}">
            <c:out value="${condiment}"/><br>
        </c:forEach>
    </h3>
</body>
</html>
