<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>${magazine.name}</title>
  <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
</head>
<body>
  <jsp:include page="header.jsp"></jsp:include>

  <div class="container-fluid single-magazine">
    <div class="col">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">${magazine.name}</h5>
          <h6 class="card-subtitle mb-2 text-muted">${magazine.price}</h6>
          <p class="card-text">${magazine.author}</p>
          <p class="card-text">${magazine.description}</p>

          <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#buySubscriptionModal">Buy subscription</button>
        </div>
      </div>
    </div>
  </div>

  <div class="modal fade" id="buySubscriptionModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          Are you to buy subscription to this magazine?
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
          <button type="button" magazine-id="${magazine.id}" class="btn btn-primary buy-subscription">Buy</button>
        </div>
      </div>
    </div>
  </div>

  <jsp:include page="footer.jsp"></jsp:include>
  <script src="vendor/bootstrap/js/popper.min.js"></script>
  <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
  <script src="js/buyMagazine.js"></script>
</body>
</html>
