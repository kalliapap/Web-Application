<%-- 
    Document   : genes
    Created on : Mar 6, 2019, 6:57:23 PM
    Author     : kalli
--%>
<%@page import="model.Assoc"%>
<%@page import="model.Gene"%>
<%@page import="database.AssocDAO"%>
<%@page import="database.GeneDAO"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <!-- Title -->
            <h1 class="mt-4">Gene Information</h1>
            <hr>
            <!-- Post Content -->
            <div class="col-sm" id="test1">
                <!--to geneID apo th selida assoc.jsp h apo thn genes.jsp einai id gia to link tou geneID-->
                 <% Gene g = GeneDAO.getGeneByName(request.getParameter("geneID").toString());%> 
                    <h1>*<%=g.getGeneID()%></h1>
                    <p><b><%=g.getGeneTitle()%></b></p>
                    <p><b>HGNC Approved Gene Symbol: </b><%=g.getGeneSymbol()%></p>
                    <p><b>Cytogenetic location:</b>  <%=g.getLocation()%> <b>  &nbsp;&nbsp;&nbsp;&nbsp;Genomic coordinates: </b><%=g.getCoordinates()%></p>
                    <p><b>Description </b></p><p><%=g.getDescription()%></p>
                    <h2>Associated Phenotypes</h2>
                    <table  style="border:1px solid black;">
                            <tr>
                                <th style="border: 1px solid black;padding: 9px">PhenotypeID</th>
                                <th style="border: 1px solid black;padding: 9px">Phenotype</th>
                            </tr>
                            <%
                                Vector<Assoc> vec = AssocDAO.getAllAssocByGeneName(g.getGeneID());
                                for(Assoc a:vec){
                            %>
                            <tr style="border: 1px solid black;">
                                
                                <td style="border: 1px solid black;padding: 5px">
                                    <a href=<%= "\"phenoPage.jsp?phenID="+a.getPhenoID()+"\""%> > <%=a.getPhenoID()%> </a>
                                </td>
                                
                                <td style="border: 1px solid black;padding: 5px">
                                    <%=a.getPhenoTitle()%>
                                </td>
                            </tr>
                    <% } %>
                    </table>
                    <hr>
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

