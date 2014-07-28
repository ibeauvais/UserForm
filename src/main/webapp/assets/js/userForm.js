$(document).ready(function () {
    $("#addUser").bind("click", function () {
        createUserForm();
    });
});


function createUserForm() {
    $.get('assets/template/userForm.htm', function (template) {
        var rendered = Mustache.render(template);
        $('#container').html(rendered);
    });
}