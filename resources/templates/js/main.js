$("#menu").children().each(
    function() {
        var location = window.location.pathname;
        var href = $(this).children().first().attr("href");
        if (location.indexOf(href) > -1)
            $(this).children().first().addClass("selected");
        else
            $(this).children().first().removeClass("selected");
    });