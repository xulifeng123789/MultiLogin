<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="com.beyondlife.vo.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>�ʻ���½</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body> 
    �˹������ڷ�ֹ��һ�ʺŵ�½�ظ���½���� <br><hr/>
    <form action="<%=request.getContextPath() %>/login" method="post">
    <table>
    <tr><td>UID:<td><td><input type="text" name="uid"/><td></tr>
    <tr><td>name:<td><td><input type="text" name="name"/><td></tr>
    <tr><td>submit:<td><td><input type="submit" value="ȷ��"/><td></tr>
    </table>    
    </form>
    <br/>
    ���û���½UID���û��������������,�������д!
    <br/>
    ��ǰ�Ѿ���½���û��б�
    <%
    Map list = (Map)application.getAttribute("ulist");
    if(list != null){
      request.setAttribute("list",list.values());
    }
     %>
     <c:forEach items="${list}" var="user">
      ${user.name }
     </c:forEach>
  </body>
</html>
