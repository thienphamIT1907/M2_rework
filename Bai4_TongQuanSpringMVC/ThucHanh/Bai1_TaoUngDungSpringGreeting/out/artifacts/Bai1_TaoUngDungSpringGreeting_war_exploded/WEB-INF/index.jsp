<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Greeting</title>
</head>
<body>
<h1>Hello: ${name}</h1>
<form action="/getDisableInput" method="get">
  <input type="text" value="hello disable" name="inputDisable" readonly>
  <input type="submit" value="Submit">
</form>
</body>
</html>