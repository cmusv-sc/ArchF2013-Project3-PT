$(function(){
    jsRoutes.controllers.Devices.getAllSensorTypes().ajax({
        beforeSend: function(){
            $('#loading').show();
        },
        success:function(data){
            $('#sensor-types').html(data);
        },
        error:function(jqxhr, code, msg){
            $('#sensor-types').html("<p>"+code+"</p>");
        },
        complete:function(){
            $('#loading').hide();
        }

    }); 
});



