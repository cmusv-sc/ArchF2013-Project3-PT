$(function(){
    jsRoutes.controllers.Devices.getDeviceTypes().ajax({
        beforeSend: function(){
            $('#metadataActivity').show();
        },
        success:function(data){
            $('#deviceTypes').html(data);
            $('#deviceTypes').attr('disabled', false);
        },
        error:function(jqxhr, code, msg){
            $('#deviceTypes').html("<option>"+code+"</option>");
            $('#deviceTypes').attr('disabled', true);
        },
        complete:function(){
            $('#metadataActivity').hide();
        }

    });

    $('#deviceTypes').change(function () {
        var selectedDeviceType = $('#deviceTypes').val();
        jsRoutes.controllers.Dashboard.getSensorTypesAndDeviceId(selectedDeviceType).ajax({
            beforeSend: function () {
                $('#metadataActivity').show();
            },
            success: function(data){
                $('#sensorTypeContainer').html(data);
            },
            error: function (jqxhr, code, msg) {
                $('#sensorTypeContainer').html(code);
            },
            complete: function () {
                $('#metadataActivity').hide();
            }
        });
    });
});



