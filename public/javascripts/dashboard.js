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
        $('#chart').empty();
        $('#y-axis').empty();
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
                var dataJsonArray = $.parseJSON(data);
                chartData(dataJsonArray);
            },
            error: function (jqxhr, code, msg) {
                $('#chartContainer').html(code);
            },
            complete: function () {
                $('#chartActivity').hide();
            }
        });
//        var data = [ { x: -1893456000, y: 92228531 }, { x: -1577923200, y: 106021568 }, { x: -1262304000, y: 123202660 }, { x: -946771200, y: 132165129 }, { x: -631152000, y: 151325798 }, { x: -315619200, y: 179323175 }, { x: 0, y: 203211926 }, { x: 315532800, y: 226545805 }, { x: 631152000, y: 248709873 }, { x: 946684800, y: 281421906 }, { x: 1262304000, y: 308745538 } ];
//        chartData(data);
    });

});

function chartData(data) {
    var graph = new Rickshaw.Graph( {
            element: document.querySelector('#chart'),
            width: 750,
            height: 250,
            series: [ {
                color: 'steelblue',
                data: data
            } ]
    } );
    var x_axes = new Rickshaw.Graph.Axis.Time({graph: graph});
    var y_axes = new Rickshaw.Graph.Axis.Y({
        graph: graph,
        orientation: 'left',
//        tickFormat: Rickshaw.Fixtures.Number.formatKMBT,
        element: document.getElementById("y-axis")
    });
    graph.render();
}



