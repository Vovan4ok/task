<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subscription Bucket</title>
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <link rel="stylesheet" href="css/bucket.css">
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <div class="container-fluid">

            <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for magazines..">

            <table id="myTable">

            </table>

    </div>

    <jsp:include page="footer.jsp"></jsp:include>

    <script src="js/bucket.js"></script>
</body>
</html>
