<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="${pageContext.request.contextPath}/">ProductCatalogue</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
	      <li><a href="${pageContext.request.contextPath}/product">Products</a></li>
	      <li><a href="${pageContext.request.contextPath}/attendant">Attendants</a></li>
	    </ul>
	  </div>
	</nav>