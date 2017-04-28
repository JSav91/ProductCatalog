<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
li { 
    display:inline;
}
</style>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid" style="display:inline-flex;margin:1;">
	    <div class="navbar-header">
	      <a  href="${pageContext.request.contextPath}/">ProductCatalogue</a>
	    </div>
	    <ul class="nav navbar-nav" style="display:inline;margin-left:50%">
	      <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
	      <li style="padding-left:20px;"><a href="${pageContext.request.contextPath}/product">Products</a></li>
	      <li style="padding-left:20px;"><a href="${pageContext.request.contextPath}/attendant">Attendants</a></li>
	    </ul>
	  </div>
	</nav>