<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
</style>
<title><tiles:insertAttribute name="title" ignore="true" /></title> 
</head> 
<body> 
<table border="0" cellpadding="0" cellspacing="0" align="center" width="100%"> 
    <%-- <tr> 
        <td height="30" colspan="2"><tiles:insertAttribute name="header" /> 
        </td> 
    </tr>  --%>
    <tr> 
        <td height="450"><tiles:insertAttribute name="body" /></td> 
    </tr> 
    <%-- <tr> 
        <td height="30" colspan="2"><tiles:insertAttribute name="footer" /> 
        </td> 
    </tr>  --%>
</table> 
</body> 
</html>  