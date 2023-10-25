function myFunction() {
    // Declare variables
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

var subscriptions = null;
$.get("subscription", function(data) {
  if(data !== null) {
      subscriptions = data;
  }
}).done(function() {
    var tableContent = "<tr class='header'>" +
        "<th style='width=20%;'>Name</th>" +
        "<th style='width=20%;'>Description</th>" +
        "<th style='width=20%;'>Price</th>" +
        "<th style='width=20%;'>PurchaseDate</th>" +
        "<th style='width=20%;'>Options</th>" +
        "</tr>";
    jQuery.each(subscriptions, function (i, value) {
        tableContent += "<tr>" +
            "<td>" + value.name + "</td>" +
            "<td>" + value.description + "</td>" +
            "<td>" + value.price + "</td>" +
            "<td>" + value.purchaseDate + "</td>" +
            "<td><button onclick='deleteSubscriptionFromBucket(" + value.subscriptionId + ")'>Delete</button></td>" +
            "</tr>";
    });

    $("table#myTable").html(tableContent);
});

function deleteSubscriptionFromBucket(subscriptionId) {
    var customUrl = "";
    var urlContent = window.location.href.split("/");
    for(var i = 0; i < urlContent.length - 1; i++) {
        customUrl += urlContent[i] + "/";
    }
    customUrl += "subscription?subscriptionId=" + subscriptionId;

    $.ajax({
        url: customUrl,
        type: "DELETE",
        success: function(data) {
            if(data == "Success") {
                location.reload();
            }
        }
    })
}
















