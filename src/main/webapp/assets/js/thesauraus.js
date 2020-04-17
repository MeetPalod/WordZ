/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import com.dict.servlets;
//import com.disc.jdbc;
$(document).ready(function () {

    //$("#result").html("js working");
      
      
    $("#btnLookup").click(function () {
        var term = $("#term").val();
        $.ajax({
            type: "GET",
            url: '/synmServlet', //synmServlet
            dataType: 'json',
            data: {'synonym': term},
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
            defs += data[x].synonym + "</p>";
        }
                }
        $("#result").html(defs);
    }
    function ajaxFailure(xhr, status, exception) {
        $("#result").html("something wrong"  + xhr.responseText); //html(jqXHR.responseText)

    }

});




