var createid;
var name = document.getElementById("name");
var address = document.getElementById("address");
var number = document.getElementById("number");
$(document).ready(function() {

    $(document).on("submit", "#createaddressbook", function(event){
        $.ajax({
            type: $("#createaddressbook").attr("method"),
            url: '/'
        }).done(function(response) {
            let body = response.substring(response.indexOf("<body>")+6,response.indexOf("</body>"));
            $("body").html(body);
        });
        event.preventDefault();
    });

    $(document).on("submit", "#createbuddyinfo", function(event){
        createid = $("#createid").val();
        let data = {"id": createid};
        $.ajax({
            type: $('#createbuddyinfo').attr("method"),
            url: '/'
        }).done(function(response) {
            let body = response.substring(response.indexOf("<body>")+6,response.indexOf("</body>"));
            $("body").html(body);
        });
        event.preventDefault();
    });

    $(document).on("submit", "#buddyinfoform", function(event){
        let data = {
            "name": $("#name").val(),
            "number": $("#number").val(),
            "address": $("#address").val(),

        };
        $.ajax({
            type: $('#buddyinfoform').attr("method"),
            url: '/',
            data: $("#buddyinfoform").serialize()
        }).done(function(response) {
            let body = response.substring(response.indexOf("<body>")+6,response.indexOf("</body>"));
            $("body").html(body);
            document.getElementById('tableName').innerHTML = name.value;
            document.getElementById('tableAddress').innerHTML = address.value;
            document.getElementById('tableNumber').innerHTML = number.value;
        });
        event.preventDefault();
    });

    $(document).ready(function() {
        $.ajax({
            url: "http://localhost:8080/"
        }).then(function() {
            document.getElementById('tableName').innerHTML = name.value;
            document.getElementById('tableAddress').innerHTML = address.value;
            document.getElementById('tableNumber').innerHTML = number.value;
        });
    });
});
