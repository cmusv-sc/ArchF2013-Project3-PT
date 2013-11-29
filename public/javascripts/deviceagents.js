$(function(){
    jsRoutes.controllers.Devices.getDeviceAgents().ajax({
        beforeSend: function(){
            $('#loading').show();
        },
        success:function(data){
            $('#device-agents').html(data);
        },
        error:function(jqxhr, code, msg){
            $('#device-agents').html("<p>"+code+"</p>");
        },
        complete:function(){
            $('#loading').hide();
        }

    }); 
});



