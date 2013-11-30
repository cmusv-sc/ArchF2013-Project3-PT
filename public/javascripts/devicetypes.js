$(function(){
    jsRoutes.controllers.Devices.getDeviceTypeList().ajax({
        beforeSend: function(){
            $('#loading').show();
        },
        success:function(data){
            $('#device-types').html(data);
        },
        error:function(jqxhr, code, msg){
            $('#device-types').html("<p>"+code+"</p>");
        },
        complete:function(){
            $('#loading').hide();
        }

    }); 
});



