<script>
    document.getElementById("btnUpdatePreferences").addEventListener("click", function(){

        var errors = "";

        //Validate Default Home
        if(document.getElementById("homeEnabledTrue").checked) {
            var home = document.getElementById("inputDefaultHome").value;
            if (home == "") {
                errors += ("Error: Address cannot be empty! \n");
            }
        }

        if(home == ""){
            home = "";
        }

        //Validate Num Markers
        var numMarkers = document.getElementById("inputNumMarkers").value;
        if(numMarkers == ""){
            errors += "Error: Number of Markers cannot be empty! \n";
        }

        //Validated
        if(errors == ""){
            var uid = document.getElementById("textUid").innerHTML;
            var homeEnabled;
            var unitEnabled;
            var unit = document.getElementById("selectUnit").value;
            var lineColor = document.getElementById("selectColor").value;
            var transitMode = document.getElementById("selectTransit").value;

            //Home Enabled
            if(document.getElementById("homeEnabledTrue").checked){
                homeEnabled = true;
            } else {
                homeEnabled = false;
            }

            //Unit Enabled
            if(document.getElementById("unitEnabledTrue").checked){
                unitEnabled = true;
            } else {
                unitEnabled = false;
            }

            window.location.href = "/updatePreferences?"+
                    "homeEnabled="+homeEnabled+
                    "&home="+home+
                    "&unitEnabled="+unitEnabled+
                    "&unit="+unit+
                    "&lineColor="+lineColor+
                    "&transitMode="+transitMode+
                    "&numMarkers="+numMarkers;
        } else {
            alert(errors);
        }


    });
</script>