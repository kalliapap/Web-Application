<%-- 
    Document   : searchresults
    Created on : Mar 14, 2019, 3:55:03 PM
    Author     : vasiliki
--%>
<%@page import="model.Gene"%>
<%@page import="database.GeneDAO"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Phenotype"%>
<%@page import="database.PhenotypeDAO"%>
<%@page import="model.Assoc"%>
<%@page import="database.AssocDAO"%>
<%@page import="java.util.*"%>
<%@page import="database.SearchDAO"%>

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
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="sign.jsp">Sign In
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Page Content -->

        <div class="container">
            <div class="row">
                <!-- Post Content Column -->
                <div class="col-lg-8">
                    <% 
                       String searchtext = request.getParameter("searchtext");

                       if (searchtext.isEmpty()) {
                           response.sendRedirect("index.jsp");
                           return;
                       }

                       Vector<Gene> vecGene = SearchDAO.searchGenes(searchtext);

                       if(!vecGene.isEmpty()){
                    %>

                    <!-- Title -->
                    <h2 class="mt-4">Genes found: <%=vecGene.size()%> </h2>
                    <hr>
                    <!-- Post Content about Genes -->
                    <p class="lead" method="get" name="geneName" action="Gene.java"></p>
                    <div class="col-sm" id="test1">
                        <table  style="border:1px solid black;">
                            <tr>
                                <th style="border: 1px solid black;padding: 9px">GeneID</th>
                                <th style="border: 1px solid black;padding: 9px">Symbol</th>
                                <th style="border: 1px solid black;padding: 9px">Title</th>                            
                                <th style="border: 1px solid black;padding: 9px">Location</th>
                                <th style="border: 1px solid black;padding: 9px">Coordinates</th>

                            </tr>
                            <%
                            
                                for(Gene g:vecGene){
                            %>
                            <tr style="border: 1px solid black;">

                                <td style="border: 1px solid black;padding: 5px">
                                    <a href=<%= "\"genePage.jsp?geneID="+g.getGeneID()+"\""%> > <%=g.getGeneID()%> </a>
                                </td>

                                <td style="border: 1px solid black;padding: 5px">
                                    <%=g.getGeneSymbol()%>
                                </td>

                                <td style="border: 1px solid black;padding: 5px">
                                    <%=g.getGeneTitle()%>
                                </td>

                                <td style="border: 1px solid black;padding: 5px">
                                    <%=g.getLocation()%>
                                </td>

                                <td style="border: 1px solid black;padding: 5px">
                                    <%=g.getCoordinates()%>
                                </td>                               
                            </tr>
                            <% } %>
                        </table>
                        <hr>
                    </div>
                    <%}%>


                    <!-- Page Content about Phenotypes-->
                    <% 
    
                       Vector<Phenotype> vecPheno = SearchDAO.searchPhenotypes(searchtext);
   
                       if(!vecPheno.isEmpty()){
                    %>

                    <!-- Post Content Column -->
                    <!-- Title -->
                    <h2 class="mt-4">Phenotypes found: <%=vecPheno.size()%> </h2>
                    <hr>
                    <!-- Post Content -->
                    <p class="lead" method="get" name="geneName" action="Gene.java"></p>
                    <div class="col-sm" id="test1">
                        <table  style="border:1px solid black;">
                            <tr>
                                <th style="border: 1px solid black;padding: 9px">PhenotypeID</th>
                                <th style="border: 1px solid black;padding: 9px">Title</th>                            
                                <th style="border: 1px solid black;padding: 9px">Description</th>
                                <th style="border: 1px solid black;padding: 9px">Text</th>

                            </tr>
                            <%
                            
                                for(Phenotype p:vecPheno){
                            %>

                            <tr style="border: 1px solid black;">

                                <td style="border: 1px solid black;padding: 5px">
                                    <a href=<%= "\"phenoPage.jsp?phenID="+p.getPhenotypeID()+"\""%> > <%=p.getPhenotypeID()%> </a>
                                </td>

                                <td style="border: 1px solid black;padding: 5px">
                                    <%=p.getPhenotypeTitle()%>
                                </td>

                                <td style="border: 1px solid black;padding: 5px">
                                    <%=p.getDescription()%>
                                </td>

                                <td style="border: 1px solid black;padding: 5px">
                                    <%=p.getPhentext()%>
                                </td>

                            </tr>
                            <% } %>
                        </table>
                        <hr>
                    </div>
                    <%}%>     


                    <!-- Page Content about Associations-->
                    <% 
    
                       Vector<Assoc> vecAsso = SearchDAO.searchAsso(searchtext);
   
                       if(!vecAsso.isEmpty()){
                    %>
                    <!-- Post Content Column -->
                    <!-- Title -->
                    <h2 class="mt-4">Associations found: <%=vecAsso.size()%> </h2>
                    <hr>
                    <!-- Post Content -->
                    <p class="lead" method="get" name="geneName" action="Gene.java"></p>
                    <div class="col-sm" id="test1">
                        <table  style="border:1px solid black;">
                            <tr>
                                <th style="border: 1px solid black;padding: 9px">GeneID</th>
                                <th style="border: 1px solid black;padding: 9px">PhenotypeID</th>
                                <th style="border: 1px solid black;padding: 9px">Phenotype</th>                            
                                <th style="border: 1px solid black;padding: 9px">Inheritance</th>
                                <th style="border: 1px solid black;padding: 9px">MappingKey</th>


                            </tr>
                            <%
                            
                                for(Assoc g:vecAsso){
                            %>

                            <tr style="border: 1px solid black;">

                                <td style="border: 1px solid black;padding: 5px">
                                    <a href=<%= "\"genePage.jsp?geneID="+g.getGeneID()+"\""%> > <%=g.getGeneID()%> </a>
                                </td>

                                <td style="border: 1px solid black;padding: 5px">
                                    <a href=<%= "\"phenoPage.jsp?phenID="+g.getPhenoID()+"\""%> ><%=g.getPhenoID()%> </a>
                                </td>

                                <td style="border: 1px solid black;padding: 5px">
                                    <%=g.getPhenoTitle()%>
                                </td>

                                <td style="border: 1px solid black;padding: 5px">
                                    <%=g.getInheritance()%>
                                </td>

                                <td style="border: 1px solid black;padding: 5px">
                                    <%=g.getMappingKey()%>
                                </td>                                

                            </tr>
                            <% } %>
                        </table>
                        <hr>
                    </div>
                    <%}%>                   



                        <%
                        if(vecGene.isEmpty() && vecPheno.isEmpty() && vecAsso.isEmpty()){
                            %><h1 class="mt-4"><br>No results found.</h1><%    
                        }
                        %>                    
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
                                            <a href="genes.jsp">Genes</a>
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
            <!-- /.row -->

        </div>
        <!-- /.container -->
        <%--
        <!-- Footer -->
        <footer class="py-5 bg-dark">
          <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
          </div>
          <!-- /.container -->
        </footer>
        --%>
        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>

</html>

