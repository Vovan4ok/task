$("button.buy-magazine").click(function() {
   var magazineId = jQuery(this).attr("magazine-id");

   $.post("bucket", {"magazineId": magazineId}, function(data) {
       if(data == "Success") {
           $("#buyMagazineModal").modal("hide");
       }
   })
});