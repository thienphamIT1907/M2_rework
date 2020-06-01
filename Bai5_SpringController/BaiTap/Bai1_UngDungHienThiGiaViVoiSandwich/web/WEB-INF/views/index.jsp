
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
    <h1>Sandwich Condiments</h1>
    <form action="save" method="post">
        <label>
            <input type="checkbox" name="condiment" value="Lettuce">Lettuce
        </label>
        <label>
            <input type="checkbox" name="condiment" value="Tomato">Tomato
        </label>
        <label>
            <input type="checkbox" name="condiment" value="Mustard">Mustard
        </label>
        <label>
            <input type="checkbox" name="condiment" value="Sprouts">Sprouts
        </label>
        <input type="submit" value="Save">
    </form>
</body>
</html>
