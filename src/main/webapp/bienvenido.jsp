<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% 
//aquí pongo todo el código java que quiera que mi servidor ejecute.

String usuario="";
try {  //AQUI VA EL CONTROL DE SESION
	usuario=session.getAttribute("attributo2").toString(); // Asignacion del valor de la variable usuario, del metodo getAttribute.
	String acceso = session.getAttribute("attributo1").toString(); // Creacion una variable "acceso", de tipo texto. Que contiene el valor del metodo "getAttribute".
 	if (!acceso.equals("1")) response.sendRedirect("cerrarsesion.jsp"); // Si el valor de acceso distinto "1", el usuario no esta logeado. Y es redireccionado a la pagina "cerrarsesion.jsp".  
} catch (Exception e) {
	response.sendRedirect("cerrarsesion.jsp"); // Si el metodo "getAttribute", devuelve una excepcion, manda al usuario a la pagina "cerrarsesion.jsp".
}

%><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenido</title>

<link rel="stylesheet" href="common/general.css">

</head>
<body>
<h1>Bienvenido <%=usuario %></h1>
Sesión iniciada
<hr/>
<a href="verdatos.jsp">Acceder a los Datos</a><br/>
<br/><br/><a href="cerrarsesion.jsp">Salir</a>
</body>
</html>