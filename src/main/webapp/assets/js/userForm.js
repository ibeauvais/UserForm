$(document).ready(function () {
    $("#addUser").bind("click", function () {
        printUserForm();
    });

});


function printUserForm() {
    $.get('assets/template/userForm.htm', function (template) {
        var rendered = Mustache.render(template);
        $('#container').html(rendered);
        $('#addNewUser').bind("click", function () {
            addNewUser();
        });
    });
}

function addNewUser() {
    var data = JSON.stringify($('#userForm').toObject());
    $.ajax({
        url: 'resources/user',
        dataType: 'json',
        contentType: "application/json",
        type: 'PUT',
        data: data,

        success: function (data) {

        }
    });
}