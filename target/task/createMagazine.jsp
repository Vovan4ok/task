<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create Magazine</title>
  <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <div class="container-fluid">
      <div class="row">
        <div class="col">
          <form action="magazine" method="post">
            <div class="form-group">
                <%--@declare id="magazinename"--%><label for="magazineName" class="form-label">Magazine name</label>
              <input type="text" class="form-control" name="magazineName" placeholder="Enter the name">
            </div>
            <div class="form-group">
                <%--@declare id="magazinedescription"--%><label for="magazineDescription" class="form-label">Magazine description</label>
              <input type="text" class="form-control" name="magazineDescription" placeholder="Enter the description">
            </div>
            <div class="form-group">
                <%--@declare id="magazineauthor"--%><label for="magazineAuthor" class="form-label">Magazine author</label>
              <input type="text" class="form-control" name="magazineAuthor" placeholder="Enter the author">
            </div>
            <div class="form-group">
                <%--@declare id="magazineprice"--%><label for="magazinePrice" class="form-label">Magazine price</label>
              <input type="number" class="form-control" name="magazinePrice" placeholder="Enter the price">
            </div>
            <button type="submit" class="btn btn-primary createMagazine">Submit</button>
          </form>
        </div>
      </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
