$(function(){
    jsRoutes.controllers.Devices.getDevices().ajax({
        beforeSend: function(){
            $('#loading').show();
        },
        success:function(data){
            $('#deviceList').html(data);
        },
        error:function(jqxhr, code, msg){
            $('#deviceList').html("<p>"+code+"</p>");
        },
        complete:function(){
            $('#loading').hide();
        }

    }); 
});



