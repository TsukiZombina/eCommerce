
<%@page session="false"%>
<%
    HttpSession sesionOk = request.getSession();
    sesionOk.invalidate();//destruye la session
%>

<jsp:forward page="index.jsp"></jsp:forward>

