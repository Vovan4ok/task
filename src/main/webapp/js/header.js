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

var userRole = null;
$.get("user-role", function(data) {
    if(data !== null) {
        userRole = data;
    }
}).done(function() {
    if(userRole === 'admin') {
        $("li.bucket-option").hide();
    } else if(userRole === 'default') {
        $("li.create-option").hide();
    }
});