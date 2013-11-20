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
        jsRoutes.controllers.Devices.getSensorTypes(selectedDeviceType).ajax({
            beforeSend: function () {
                $('#metadataActivity').show();
            },
            success: function (data) {
                $('#sensorTypes').html(data);
                $('#sensorTypes').attr('disabled', false);
            },
            error: function (jqxhr, code, msg) {
                $('#sensorTypes').html("<option>"+code+"</option>");
                $('#sensorTypes').attr('disabled', true);
            },
            complete: function () {
                $('#metadataActivity').hide();
            }
        });
    });
});



