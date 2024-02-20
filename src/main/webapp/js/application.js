$(document).ready(function () {
    $('a[href=catalogueBack]').on('click', function (event) {
        event.preventDefault();

        if ($('body').children().length<12) {
            $.ajax({
                url: "catalogueBack",
                success: function (result) {
                    $("a[href=catalogueBack]").after('<br>'+result);
                }
            });
        }
    });
});
