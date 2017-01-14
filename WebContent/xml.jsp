<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="folder_class.info" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% info emp = new info();

ArrayList<info> list = new ArrayList<info>();
//storing passed value from jsp
list = (ArrayList<info>)request.getAttribute("list");

for(int i = 0; i < list.size(); i++) {

emp = list.get(i);
out.println(emp.getFirst_name());

out.println(emp.getLast_nme());

out.println(emp.getNick_name());
out.println(emp.getId());
out.println(emp.getSalary());
}
%>
</body>
</html>