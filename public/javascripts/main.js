$(function(){
    jsRoutes.controllers.Devices.index().ajax({
        beforeSend: function(){
            $('#metadataActivity').show();
        },
        success:function(data){
            $('#deviceDropdownContainer').html(data);
        },
        error:function(jqxhr, code, msg){
            $('#deviceDropdownContainer').html(code);
        },
        complete:function(){
            $('#metadataActivity').hide();
        }

    });
});

