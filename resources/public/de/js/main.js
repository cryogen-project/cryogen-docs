$("#cpyear").text(new Date().getFullYear());

$("#menu").children().each(
    function () {
        var location = window.location.pathname;
        $(this).children().first().removeClass("selected");

        if (location == "/de" || location == "/de/index.html") {
            $("#home-link").addClass("selected");
        }
        else if (location.indexOf("docs") > -1) {
            $("#docs-link").addClass("selected");
        }
    }
);