$(function(){
    jsRoutes.controllers.Devices.getDevices().ajax({
        beforeSend: function(){
            $('#loading').show();
        },
        success:function(data){
            $('#sensors').html(data);
        },
        error:function(jqxhr, code, msg){
            $('#sensors').html("<p>"+code+"</p>");
        },
        complete:function(){
            $('#loading').hide();
        }

    }); 
});



