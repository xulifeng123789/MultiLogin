<%@ page language="java" import="java.util.*" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��½�ɹ�</title>
</head>
<body>
��ϲ��!��½�ɹ�!
<hr/>
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
<hr/>

�����Ҫ����Ч���������½�һ���������ע�Ȿҳ�治Ҫ�رգ���<br/>
��ͬ����UID��½���û����������ȡ������UIDһ��Ҫ��ͬ����<br/>
��½�������´򿪱�ҳ�棨�ڼ�ʱ�������Ϊ���룩��ˢ�£�<br/>
<a href="admin/test.jsp">test</a>
</body>
</html>