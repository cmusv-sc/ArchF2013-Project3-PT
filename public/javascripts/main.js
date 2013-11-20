$(function(){
    jsRoutes.controllers.Devices.getDeviceTypes().ajax({
        beforeSend: function(){
            $('#metadataActivity').show();
        },
        success:function(data){
            $('#deviceTypeContainer').html(data);
        },
        error:function(jqxhr, code, msg){
            $('#deviceTypeContainer').html(code);
        },
        complete:function(){
            $('#metadataActivity').hide();
        }

    });
});

