<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"><script src='<c:url value="js/bootstrap.min.js"></c:url>'></script>
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<style type="text/css">
.bg-1 { 
    background-color: #1abc9c; /* Green */
    color: #ffffff;
    }
</style>
</head>
<body>
	<jsp:include page="_menu.jsp"></jsp:include>
	<div class="jumbotron text-center bg-1">
		<h1>Products</h1>
		<p>Browse and manage products!</p>   	
	</div>
	
	
	<div class="container">
		<div class="row">
			<div class="col">
			</div>
		</div>
		<form action="product">
		<div class="row">

			<div class=".col-sm-4 .col-lg-4">
				<input name ="searchByName" class="form-control" placeholder="Search By Product Name"/>
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
                            Product List
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>Product ID</th>
                                            <th>Product Name</th>
                                            <th>Price</th>
                                            <th>Stock</th>
                                            <th>Comments</th>
                                            <th>Edit</th>
         									<th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${productList}" var="product" >
                                        <tr>
                                            <td>${product.productId}</td>
                                            <td>${product.productName}</td>
                                            <td>${product.productPrice}</td>
                                            <td>${product.productStock}</td>
                                            <td>${product.productComments}</td>
                                            <td>
								              <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#modalEdit${product.productId}">Edit</button>
								               
												 <!-- Edit Modal -->
													<c:if test="${not empty product}">
										                      <form action="editProduct">
										                      			<div class="modal fade" id="modalEdit${product.productId}" role="dialog">
																		    <div class="modal-dialog">
																		    
																		      <!-- Modal content-->
																		      <div class="modal-content">
																		        <div class="modal-header">
																		          <button type="button" class="close" data-dismiss="modal">&times;</button>
																		          <h4 class="modal-title">Edit Product</h4>
																		        </div>
																		        <div class="modal-body">
																		        	<input type="hidden" name="id" value="${product.productId}" />
																			       <table>
																			          <tr>
																			             <td>Product Name </td>
																			             <td><input type="text" name="name" value="${product.productName}" /></td>
																			          </tr>
																			          <tr>
																			             <td>Product price </td>
																			             <td><input type="text" name="price" value="${product.productPrice}" /></td>
																			          </tr>
																			          <tr>
																			             <td>Stock </td>
																			             <td><input type="text" name="stock" value="${product.productStock}" /></td>
																			          </tr>
																			          <tr>
																			             <td>Product comment </td>
																			             <td><input type="text" name="comment" value="${product.productComments}" /></td>
																			          </tr>
																			       </table>
																		        </div>
																		        <div class="modal-footer">
																		          <button type="submit" class="btn btn-info" role="button">Save product</button>
																		          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
																		        </div>
																		      </div>
																		      
																		    </div>
																		  </div>
										  
										                            </form>   
										                 </c:if>   
								               
								            </td>
								            <td>
								            	<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#modalDelete${product.productId}">Delete</button>
								            							<c:if test="${not empty product}">
								            							<form action="deleteProduct">
									            								<div class="modal fade" id="modalDelete${product.productId}" role="dialog">
																				    <div class="modal-dialog">
																				    
																				      <!-- Modal content-->
																				      <div class="modal-content">
																				        <div class="modal-header">
																				          <button type="button" class="close" data-dismiss="modal">&times;</button>
																				          <h4 class="modal-title">Confirm Delete</h4>
																				        </div>
																				        <div class="modal-body">
																				        
																				        	<input type="hidden" name="id" value="${product.productId}" />
																				        	<p> Delete product "${product.productName}" ? </p>
																					       
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
                                <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">New Product</button>
                                
                                
                              </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
		
		</div>
	
	  <!-- Modal -->
                      <form action="createProduct"><div class="modal fade" id="myModal" role="dialog">
								    <div class="modal-dialog">
								    
								      <!-- Modal content-->
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">Create new Product</h4>
								        </div>
								        <div class="modal-body">
									       <table>
									          <tr>
									             <td>Product Name: </td>
									             <td><input type="text" name="name" value="${product.productName}" /></td>
									          </tr>
									          <tr>
									             <td>Product price: </td>
									             <td><input type="text" name="price" value="${product.productPrice}" /></td>
									          </tr>
									          <tr>
									             <td>Stock: </td>
									             <td><input type="text" name="stock" value="${product.productStock}" /></td>
									          </tr>
									          <tr>
									             <td>Product comments: </td>
									             <td><input type="text" name="comment" value="${product.productComment}" /></td>
									          </tr>
									       </table>
								        </div>
								        <div class="modal-footer">
								          <button type="submit" class="btn btn-info" role="button">Create product</button>
								          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
								        </div>
								      </div>
								      
								    </div>
								  </div>
  
                            </form>          								        
                                
								  

	<jsp:include page="_footer.jsp"></jsp:include>
 
</body>
</html>