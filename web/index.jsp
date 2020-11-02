<%-- 
    Document   : index
    Created on : Mar 5, 2019, 4:47:48 PM
    Author     : kalli
--%>

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
      <a class="navbar-brand" href="#">Geneius</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link active" href="index.jsp">Home
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
            <h1 class="mt-4">Geneius</h1>
            <!-- Author -->
            <p class="lead">
              by
              <a href="#">Vasiliki Kotsira</a></br>
              and
              <a href="#">Kalliopi Papanastou</a>
            </p>
            <hr>
            <!-- Date/Time -->
            <p>Created on March 6, 2019 at 12:00 PM</p>
            <hr>
            <!-- Preview Image -->
            <img class="img-fluid rounded" src="home.png" alt="">
            <hr>
            <!-- Post Content -->
            <p class="lead">Welcome to Geneius, a database for mapping genes and phenotypes. This database was initiated in 2019 by Kotsira Vasiliki and Papanastou Kalliopi, two Bioinformaticians from University of Athens.  </p>
            <p>Here, you can find associations between genes and phenotypes. There are over 15,000 genes and all known disorders. Database is updated daily. </p>
            <p>Geneius is authored and edited at the University of Athens, School of Biology, under the direction of Vasiliki Kotsira and Kalliopi Papanastou.</p>
            <hr>
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
