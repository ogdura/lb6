<%@ page import="java.io.File" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<link rel="stylesheet" href="style.css">
<body>

<c:forEach var="row" items="${map}">
    <c:forEach var="nrow" items="${row}" varStatus="сounter">
        <c:if test="${сounter.count == 1}">
            <h1>${nrow}</h1>
            <c:set var="dir" value="${nrow}" />
        </c:if>
        <c:if test="${сounter.count > 1}">
        <c:if test="${nrow != null}">
            <form action="" method="post" >
                <p>${nrow}</p>
                <input type="hidden" value="${dir}_${nrow}" name="namee">
                <input type="submit" value="Открыть">
            </form>
        </c:if>
        </c:if>
    </c:forEach>
    </form>
</c:forEach>
<br/>
</body>
</html>