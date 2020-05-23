<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Hiển thị danh sách khách hàng</title>
  <style>
    body {
      width: 80%;
      margin: 0 auto;
    }
  </style>
</head>
<body>
<table border = "1">
  <tr>
    <th>Tên</th>
    <th>Ngày sinh</th>
    <th>Địa chỉ</th>
    <th>Ảnh</th>
  </tr>

  <c:forEach items="${customerArrayList}" var="i">
    <tr>
      <td><c:out value="${i.getHoTen()}"/></td>
      <td><c:out value="${i.getNgaySinh()}"/></td>
      <td><c:out value="${i.getDiaChi()}"/></td>
      <td><img src="./images/${i.getAnh()}" alt="picture" width="20%"></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>