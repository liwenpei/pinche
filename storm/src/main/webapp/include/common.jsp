<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%
response.addHeader("pragma", "no-store,no-cache");//HTTP 1.0
response.addHeader("cache-control", "no-cache, no-store,must-revalidate, max-age=-1"); // HTTP 1.1
response.addHeader("expires", "-1");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
String ctx = request.getContextPath();
%>
