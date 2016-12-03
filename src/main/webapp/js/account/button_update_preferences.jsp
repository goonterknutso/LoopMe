<script>
    document.getElementById("btnUpdatePreferences").addEventListener("click", function(){

        var errors = "";

        //Validate Default Home
        var home = document.getElementById("inputDefaultHome").value;
        if(home == ""){
            errors += ("Error: Address cannot be empty! \n");
        } else {
            var geocoder = new google.maps.Geocoder();
            geocoder.geocode({'address': home}, function (results, status) {
                if (status === 'OK') {
                    /*locationVerified = true;
                    alert("location verified");
                    alert(results);
                    lat = results[0].geometry.location.lat();
                    lng = results[0].geometry.location.lng();
                    alert("LatLng: "+lat+" "+lng);*/
                } else {
                    errors += ("Error: Not a valid address!\n");
                }
            });
        }

        //Validate Num Markers
        var numMarkers = document.getElementById("inputNumMarkers").value;
        if(numMarkers == ""){
            errors += "Error: Number of Markers cannot be empty! \n";
        }

        //Validated
        if(errors == ""){
            var uid = document.getElementById("textUid");
            var homeEnabled;
            var unitEnabled;
            var lineColor = document.getElementById("selectColor").value;
            var transitMode = document.getElementById("selectTransit").value;

            //Home Enabled
            if(document.getElementById("homeEnabledTrue").checked){
                unitEnabled = true;
            } else {
                unitEnabled = false;
            }

            //Unit Enabled
            if(document.getElementById("unitEnabledTrue").checked){
                unitEnabled = true;
            } else {
                unitEnabled = false;
            }


            /*window.location.href =*/ alert( "/updatePreferences?uid="+uid+
                    "&homeEnabled="+homeEnabled+
                    "&home="+home+
                    "&unitEnabled="+unitEnabled+
                    "&lineColor="+lineColor+
                    "&transitMode="+transitMode+
                    "&numMarkers="+numMarkers);
        } else {
            alert(errors);
        }


    });
</script>