<%@ page import="jr.jarrobots.website.Question" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page isELIgnored="false" %>

<% Question question = (Question) request.getAttribute("question"); %>
<div><h3><%=question.getName()%></h3></div>
<div><h1><%=question.getGroup()%></h1></div>
<div id=guestion">
</div>
<fieldset>
    <div>
        <ul>
           <% for( int i=0; i<question.getAnswers().size(); i+=1) { %>
                <li>
                <input id = <%=i+1%> type="checkbox" class="check" name="answer"/>
                <label> for=<%=i+1%> <%=question.getAnswers().get(i)%> </label>
                </li>
        <% } %>
        </ul>
    </div>
</fieldset>
<form action="diva" method="post">
    <button name="button1">WSTECZ</button>
    <button name="button2">DALEJ</button>
</form>
</body>
</html>
