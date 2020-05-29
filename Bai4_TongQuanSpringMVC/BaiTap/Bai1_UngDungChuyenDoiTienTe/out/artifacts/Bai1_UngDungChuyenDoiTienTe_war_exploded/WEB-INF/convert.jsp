
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<form action="/convert" method="post">
    Rate:
    <label>
        <input type="text" name="rate"/>
    </label>
    <br/>
    USD:
    <label>
        <input type="text" name="usd"/>
    </label>
    <br/>
    VND:
    <label>
        <input type="text" disabled/>
    </label>
    <br/>
    <input type="submit" value="Convert">
</form>
</body>
</html>
