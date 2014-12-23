$("#menu").children().each(
    function () {
        var location = window.location.pathname;
        $(this).children().first().removeClass("selected");

        if (location == "/" || location == "/index.html") {
            $("#home-link").addClass("selected");
        }
        else if (location.indexOf("docs") > -1) {
            $("#docs-link").addClass("selected");
        }
    }
);