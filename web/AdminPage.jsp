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
                                 <a class="nav-link" href="<%=request.getContextPath()%>/LogoutServlet"  >Sign Out
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


        <%
          if(currentUser != null){
        %>

        <div class="container">
            <div class="row">
                <!-- Post Content Column -->
                <div class="col-lg-8">
                    <!-- Title -->
                    <h1 class="mt-4">Administrator Page</h1>
                    <hr>
                    <p>Administrator <%=currentUser.getEmail()%>, welcome. From here you can insert, delete or update database. Please choose below what action you want to perform.</p>
                    <div class="card my-4">
                        <h5 class="card-header">Choose Action</h5>
                        <div class="card-body">
                            <form method="get">
                                <% int x; %>
                                <a href=<%= "\"AdminInsertion.jsp?item="+1+"\""%> >Insert Gene</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href=<%= "\"AdminUpdate.jsp?item="+1+"\""%> >Update Gene</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href=<%= "\"AdminDelete.jsp?item="+1+"\""%> >Delete Gene</a></br>
                                <a href=<%= "\"AdminInsertion.jsp?item="+2+"\""%> >Insert Phenotype</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href=<%= "\"AdminUpdate.jsp?item="+2+"\""%> >Update Phenotype</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href=<%= "\"AdminDelete.jsp?item="+2+"\""%> >Delete Phenotype</a></br>
                                <a href=<%= "\"AdminInsertion.jsp?item="+3+"\""%> >Insert Association</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href=<%= "\"AdminUpdate.jsp?item="+3+"\""%> >Update Association</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href=<%= "\"AdminDelete.jsp?item="+3+"\""%> >Delete Association</a></br>
                                <a href=<%= "\"AdminInsertion.jsp?item="+4+"\""%> >Create User</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href=<%= "\"AdminUpdate.jsp?item="+4+"\""%> >Update User</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href=<%= "\"AdminDelete.jsp?item="+4+"\""%> >Delete User</a>
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
        <% }else{ %>
        <a href="sign.jsp"/>
        <% } %>
        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>

</html>
