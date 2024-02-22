$(document).ready(function () {
    $('a[href=catalogueBack]').on('click', function (event) {
        event.preventDefault();

        if ($('body').children().length<6) {
            $.ajax({
                url: "catalogueBack",
                success: function (result) {
                    var catalog='';
                    result.forEach(function(nextWork){
                        catalog=catalog.concat(nextWork.title+" ("+nextWork.release+")<BR/>");
                    });

                    $("a[href=catalogueBack]").after('<br>'+catalog);
                }
            });
        }
    });
});