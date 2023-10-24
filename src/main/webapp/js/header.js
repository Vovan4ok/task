$(document).ready(function() {
    $('.leftmenutrigger').on('click', function(e) {
        $('.side-nav').toggleClass("open");
        e.preventDefault();
    });
    $("button.logout").on('click', function() {
        $.get("logout", function(data) {
            if(data !== "") {
                var customURL = "";
                var urlContent = window.location.href.split("/");
                for(var i = 0; i < urlContent.length - 1; i++) {
                    customURL += urlContent[i] + "/";
                }
                customURL += data;
                window.location = customURL;
            }
        });
    });
});