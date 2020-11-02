<%-- 
    Document   : index
    Created on : Mar 5, 2019, 4:47:48 PM
    Author     : kalli
--%>
<%@page language="java"
        contentType="text/html" pageEncoding="UTF-8"
        import="model.User"
        %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Administrator</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/blog-post.css" rel="stylesheet">

        <script src="https://code.jquery.com/jquery-1.10.2.js"
        type="text/javascript"></script>
        <script src="login.js" type="text/javascript"></script>
    </head>

    <body>
        <% 
            User currentUser = (User)(session.getAttribute("currentSessionUser"));
            if(currentUser == null)
                response.sendRedirect("sign.jsp"); //logged in        
        %>
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

                        <%
                            if(currentUser != null){
                        %>
                        <li class="nav-item">
                            <a class="nav-link active" href="AdminPage.jsp">Admin
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>                        
                        <li class="nav-item">
                            <form method="get" action="LogoutServlet">
                                <input type="hidden" name="LogOut" value="LogOut"/>
                                <a class="nav-link active" href="<%=request.getContextPath()%>/LogoutServlet"  >Sign Out
                                    <span class="sr-only">(current)</span>
                                </a> 
                            </form> 
                        </li>
                        <% }else{%>
                        <li class="nav-item">
                            <a class="nav-link active" href="sign.jsp">Sign In
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="row">
                <!-- Post Content Column -->
                <div class="col-lg-8">
                    <%
                        String item = request.getParameter("item").toString();
                        System.out.println("item="+item);
                        if(item.equals("1")){
                    %>
                    <div class="card my-4">
                        <h5 class="card-header">Delete Gene</h5>
                        <div class="card-body">
                            <form action="AdminDeleteServlet">
                                <input type="hidden" name="it" value="1"/>
                                <label ><b>GeneID</b></label>
                                <input type="text" class="form-control" placeholder="Enter GeneID" name="gid" required>
                                </br>
                                <span class="input-group-btn">
                                    <button class="btn btn-secondary" type="submit" value="submit">Delete Gene</button>
                                </span>
                            </form>
                        </div>
                    </div>
                    <% }else if(item.equals("2")){ %>
                    <div class="card my-4">
                        <h5 class="card-header">Delete Phenotype</h5>
                        <div class="card-body">
                            <form action="AdminDeleteServlet">
                                <input type="hidden" name="it" value="2"/>
                                <label ><b>PhenotypeID</b></label>
                                <input type="text" class="form-control" placeholder="Enter PhenotypeID" name="pid" required>
                                </br>
                                <span class="input-group-btn">
                                    <button class="btn btn-secondary" type="submit" value="submit">Delete Phenotype</button>
                                </span>
                            </form>
                        </div>
                    </div>
                    <% }else if(item.equals("3")){ %>
                    <div class="card my-4">
                        <h5 class="card-header">Delete Association</h5>
                        <div class="card-body">
                            <form action="AdminDeleteServlet">
                                <input type="hidden" name="it" value="3"/>
                                <label  ><b>PhenotypeID</b></label>
                                <input type="text" class="form-control" placeholder="Enter PhenotypeID" name="pid" required>

                                <label ><b>GeneID</b></label>
                                <input type="text" class="form-control" placeholder="Enter GeneID" name="gid" required>

                                <label ><b>Phenotype Title</b></label>
                                <input type="text" class="form-control" placeholder="Enter Phenotype Title" name="title" required>
                                </br>
                                <span class="input-group-btn">
                                    <button class="btn btn-secondary" type="submit" value="submit">Delete Association</button>
                                </span>
                            </form>
                        </div>
                    </div>
                    <% }else if(item.equals("4")){ %>
                    <div class="card my-4">
                        <h5 class="card-header">Delete User</h5>
                        <div class="card-body">
                            <form action="AdminDeleteServlet">
                                <input type="hidden" name="it" value="4"/>
                                <label ><b>Email</b></label>
                                <input type="text" class="form-control" placeholder="Enter Email" name="email" required>
                                </br>
                                <span class="input-group-btn">
                                    <button class="btn btn-secondary" type="submit" value="submit">Delete User</button>
                                </span>
                            </form>
                        </div>
                    </div>
                    <% } %>
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
