<%-- 
    Document   : index
    Created on : Mar 5, 2019, 4:47:48 PM
    Author     : kalli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>OurDatabase</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/blog-post.css" rel="stylesheet">
    
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="login.js" type="text/javascript"></script>
</head>

<body>
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="index.jsp">Geneius</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item ">
            <a class="nav-link" href="index.jsp">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
       
          <li class="nav-item">
            <a class="nav-link active" href="sign.jsp">Sign In
              <span class="sr-only">(current)</span>
            </a>
          </li>
        
        </ul>
      </div>
    </div>
  </nav>
  
  <!-- Page Content -->
  <div class="container">

    <div class="row"  >
         <!-- Sidebar Widgets Column -->
        <div class="col-lg-8">
            <div class="card my-4">
            <h5 class="card-header">Sign In</h5>
                <div class="card-body">
                    <form method="get" action="LoginServlet">
                        <label for="email" ><b>Username</b></label>
                        <input type="text" class="form-control" placeholder="Enter email" name="email" required>

                        <label for="psw"><b>Password</b></label>
                        <input type="password" class="form-control" placeholder="Enter Password" name="psw" required>
                        </br>
                        <span class="input-group-btn">
                            <button class="btn btn-secondary" type="submit" value="submit">Login!</button>
                        </span>
                    </form>
                </div>
            </div>
        </div> 
         
           <!-- Sidebar Widgets Column -->
      <div class="col-md-4">
        <!-- Search Widget -->
        <div class="card my-4">
          <h5 class="card-header">Search</h5>
          <div class="card-body">
              <form action="searchresults.jsp" method="POST">
            <div class="input-group">
                
              <input type="text" name="searchtext" class="form-control" placeholder="Search Geneius...">
              <span class="input-group-btn">
                <button class="btn btn-secondary" type="submit">Go!</button>
              </span>
              </div>
                </form>
            
          </div>
        </div>

        <!-- Categories Widget -->
        <div class="card my-4">
          <h5 class="card-header">Categories</h5>
          <div class="card-body">
            <div class="row">
              <div class="col-lg-6">
                <ul class="list-unstyled mb-0">
                  <li>
                    <a href="genes.jsp" >Genes</a>
                  </li>
                  <li>
                    <a href="phenotypes.jsp">Phenotypes</a>
                  </li>
                   <li>
                    <a href="assoc.jsp">Associations</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
</div>
  </div>
  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
