<%@ page import="jr.jarrobots.website.Question" %><%--
  Created by IntelliJ IDEA.
  User: jarek
  Date: 01/08/2022
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page isELIgnored="false" %>
<% String name = request.getSession().getAttribute("List").toString();%>
<p>Test:<%=name%></p>
<div id=guestion">
</div>
<fieldset>
    <div>
        <ul></ul>
    </div>
</fieldset>
<button type="button">WSTECZ</button>
<button type="button">DALEJ</button>
</body>
</html>
