$(function(){
    $('#fromTime').datetimepicker({
        closeOnDateSelect: true,
        onChangeDateTime: function(dp, $input){
            $('#fromTimeEpoch').val(Date.parse($input.val()));
        }
    });
    $('#toTime').datetimepicker({
        closeOnDateSelect: true,
        onChangeDateTime:function(dp, $input){
            $('#toTimeEpoch').val(Date.parse($input.val()));
        }
    });
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

    $('#goChart').click(function(){
        var sensorForm = new FormData($('#sensorForm')[0]);
        /*$.ajax({
            url:"@routes.Dashboard.getReading()",
            type: 'GET',
//            data:sensorForm,
            success: function(data){
                $('#chartData').html(data);
            },
            error: function (jqxhr, code, msg) {
                $('#chartData').html(code);
            },
            complete: function () {
                $('#metadataActivity').hide();
            }
        });*/
        jsRoutes.controllers.Dashboard.getReading().ajax({
            data: {
                device_id: $('#deviceId').val(),
                sensor_type: $('#sensorType').val(),
                start_time: $('#fromTimeEpoch').val(),
                end_time: $('#toTimeEpoch').val()
            },
            beforeSend: function () {
                $('#chartActivity').show();
            },
            success: function(data){
                $('#chartData').html(data);
            },
            error: function (jqxhr, code, msg) {
                $('#chartData').html(code);
            },
            complete: function () {
                $('#chartActivity').hide();
            }
        });
    });
});



