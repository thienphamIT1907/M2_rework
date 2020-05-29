
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
    <h1>Dictionary</h1>
    <form action="/dictionary" method="post">
        English:
        <label>
            <input type="text" name="eng">
        </label>
        <br/>
        Vietnamese:
        <label>
            <input type="text" name="vie" disabled>
        </label>
        <br/>
        <input type="submit" value="Translate">
    </form>
</body>
</html>
