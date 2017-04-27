<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendant</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"><script src='<c:url value="js/bootstrap.min.js"></c:url>'></script>
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<style type="text/css">
.bg-2 { 
    background-color: #474e5d; /* Dark Blue */
    color: #ffffff;
}
</style>
</head>
<body>

	<jsp:include page="_menu.jsp"></jsp:include>
	
	<div class="jumbotron text-center bg-2">
	  	<h1>Attendants</h1>
	  	<p>Browse and manage attendants!</p> 
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col">
			</div>
		</div>
		<form action="product">
		<div class="row">

			<div class=".col-sm-4 .col-lg-4">
				<input name ="searchByName" class="form-control" placeholder="Search By Attendant Name"/>
			</div>
			<div class=".col-sm-4 .col-lg-4">
				<button type="submit" class="btn btn-info" role="button">Search</button>
			</div>
		</div>
		</form>
			<c:if test="${not empty errorString}">
				<div class="alert alert-info alert-dismissable" style="color: red;">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				  <strong>Info!</strong> ${errorString}
				</div>
			</c:if>
		<div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Attendant List
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>Attendant ID</th>
                                            <th>Attendant Name</th>
                                            <th>Address</th>
                                            <th>Mobile No</th>
                                            <th>Comments</th>
                                            <th>Edit</th>
         									<th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${attendantList}" var="attendant" >
                                        <tr>
                                            <td>${attendant.attendantId}</td>
                                            <td>${attendant.attendantName}</td>
                                            <td>${attendant.attendantAddress}</td>
                                            <td>${attendant.attendantPhone}</td>
                                            <td>${attendant.attendantComments}</td>
                                            <td>
								              <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#modalEdit${attendant.attendantId}">Edit</button>
								               
												 <!-- Edit Modal -->
													<c:if test="${not empty attendant}">
										                      <form action="editAttendant">
										                      			<div class="modal fade" id="modalEdit${attendant.attendantId}" role="dialog">
																		    <div class="modal-dialog">
																		    
																		      <!-- Modal content-->
																		      <div class="modal-content">
																		        <div class="modal-header">
																		          <button type="button" class="close" data-dismiss="modal">&times;</button>
																		          <h4 class="modal-title">Edit Attendant</h4>
																		        </div>
																		        <div class="modal-body">
																		        	<input type="hidden" name="id" value="${attendant.attendantId}" />
																			       <table>
																			          <tr>
																			             <td>Attendant Name </td>
																			             <td><input type="text" name="name" value="${attendant.attendantName}" /></td>
																			          </tr>
																			          <tr>
																			             <td>Attendant Address </td>
																			             <td><input type="text" name="address" value="${attendant.attendantAddress}" /></td>
																			          </tr>
																			          <tr>
																			             <td>Attendant Phone </td>
																			             <td><input type="text" name="phone" value="${attendant.attendantPhone}" /></td>
																			          </tr>
																			          <tr>
																			             <td>Attendant comment </td>
																			             <td><input type="text" name="comment" value="${attendant.attendantComments}" /></td>
																			          </tr>
																			       </table>
																		        </div>
																		        <div class="modal-footer">
																		          <button type="submit" class="btn btn-info" role="button">Save attendant</button>
																		          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
																		        </div>
																		      </div>
																		      
																		    </div>
																		  </div>
										  
										                            </form>   
										                 </c:if>   
								               
								            </td>
								            <td>
								            	<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#modalDelete${attendant.attendantId}">Delete</button>
								            							<c:if test="${not empty attendant}">
								            							<form action="deleteProduct">
									            								<div class="modal fade" id="modalDelete${attendant.attendantId}" role="dialog">
																				    <div class="modal-dialog">
																				    
																				      <!-- Modal content-->
																				      <div class="modal-content">
																				        <div class="modal-header">
																				          <button type="button" class="close" data-dismiss="modal">&times;</button>
																				          <h4 class="modal-title">Confirm Delete</h4>
																				        </div>
																				        <div class="modal-body">
																				        
																				        	<input type="hidden" name="id" value="${attendant.attendantId}" />
																				        	<p> Delete attendant "${attendant.attendantName}" ? </p>
																					       
																				        </div>
																				        <div class="modal-footer">
																				           <button type="submit" class="btn btn-info" role="button">Delete</button>
																				          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
																				        </div>
																				      </div>
																				      
																				    </div>
																			  </div>
																		 </form>
																	</c:if>
								            </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">New Attendant</button>
                                
                                
                              </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
		
		</div>
	
	  <!-- Modal -->
                      <form action="createAttendant"><div class="modal fade" id="myModal" role="dialog">
								    <div class="modal-dialog">
								    
								      <!-- Modal content-->
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">Add new Attendant</h4>
								        </div>
								        <div class="modal-body">
									       <table>
									          <tr>
									             <td>Attendant Name: </td>
									             <td><input type="text" name="name" value="${attendant.attendantName}" /></td>
									          </tr>
									          <tr>
									             <td>Attendant Address: </td>
									             <td><input type="text" name="address" value="${attendant.attendantAddress}" /></td>
									          </tr>
									          <tr>
									             <td>Phone : </td>
									             <td><input type="text" name="phone" value="${attendant.attendantPhone}" /></td>
									          </tr>
									          <tr>
									             <td>Attendant comments: </td>
									             <td><input type="text" name="comment" value="${attendant.attendantComments}" /></td>
									          </tr>
									       </table>
								        </div>
								        <div class="modal-footer">
								          <button type="submit" class="btn btn-info" role="button">Add attendant</button>
								          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
								        </div>
								      </div>
								      
								    </div>
								  </div>
  
                            </form>          								        
                                
								  
	
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>