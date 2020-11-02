$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });



$('#resetPassword').on('click', function (e) {
alert("jhsdgfhgsdhfg");
e.preventDefault();
e.stopPropagation();
var $form = $( this);
    $.ajax({
        type: 'POST',
        url: $(this).attr("action"),
        data: $(this).serialize(),
        success: function(data) {
        $('div#ack').empty().append(data);

        }

    });

    e.preventDefault();
    return false;
});
});
