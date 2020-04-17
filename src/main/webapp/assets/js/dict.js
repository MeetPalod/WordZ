/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    //$('#loadingDiv').hide();
    // $("#result").html("js working");
      
    $("#btnLookup").click(function () {
        var term = $("#term").val();
        $.ajax({
            //async: 'false',
            type: "POST",
            url: '/discServlet',
            dataType: 'json',
            data: {'word': term},
            success: ajaxSuccess,
            error: ajaxFailure

        });
    });
    function ajaxSuccess(data) {
        var defs = "";
        if(data.length=== 0){
            defs = "No matching word found!!!!!!! , Please check your spelling!";
                    $("#result").html(defs);
                    $('#loadingDiv').fadeOut();
                    
                }else{
        for (var x = 0; x < data.length; x++) {
            var count = x + 1;
            defs += "<p>" + count;
            defs += "(" + data[x].wordtype + ") ==>> ";
            defs += data[x].definition + "</p>";
        }
                }
        $("#result").html(defs);
    }
    function ajaxFailure(xhr, status, exception) {
        // alert('fail');
        $("#result").html("something wrong");
        // console.log(xhr, status, exception);

    }

});




