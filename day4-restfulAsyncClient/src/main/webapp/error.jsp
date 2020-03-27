<%--
  Created by IntelliJ IDEA.
  User: lts
  Date: ٢٧‏/٣‏/٢٠٢٠
  Time: ١:٠٠ ص
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<h2>error page</h2>
<%
    String messages = (String) request.getAttribute("errorMessage");
    if (messages != null && !messages.equals("")) {
%>
<p style="color: red;"><%= messages %>
</p>
<%
    }

    String errorNumber = (String) request.getAttribute("errorNumber");
    if (errorNumber != null && !errorNumber.equals("")) {
%>
<p style="color: red;"><%= errorNumber %>
</p>
<%
    }
%>
</body>
</html>
