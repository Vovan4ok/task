$("button.buy-subscription").click(function() {
   var magazineId = jQuery(this).attr("magazine-id");

   $.post("subscription", {"magazineId": magazineId}, function(data) {
       if(data == "Success") {
           $("#buySubscriptionModal").modal("hide");
       }
   });
});