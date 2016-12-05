<script>
    document.getElementById("btnGenerate").addEventListener("click", validateForm);

    function validateForm(){

        var locationVerified = false;
        var distanceVerified = false;

        var lat = "";
        var lng = "";

        //Check address input and distance input
        var address = document.getElementById("inputLocation").value;
        var distance = document.getElementById("inputDistance").value;
        var unit = document.getElementById("inputDistanceUnit").value;

        if(address == ""){
            alert("Error: Address cannot be empty!");
        } else if(distance == ""){
            alert("Error: Distance cannot be empty!");
        } else if(isNaN(distance)) {
            alert("Error: Distance must be a number!");
        } else {
            distanceVerified = true;
            var geocoder = new google.maps.Geocoder();
            geocoder.geocode({'address': address}, function (results, status) {
                if (status === 'OK') {
                    locationVerified = true;
                    lat = results[0].geometry.location.lat();
                    lng = results[0].geometry.location.lng();

                    if(locationVerified && distanceVerified){

                        //Build url
                        window.location.href = "/createMap?address="+address+
                                "&lat="+lat+
                                "&lng="+lng+
                                "&distance="+distance+
                                "&unit="+unit;
                    }
                 } else {
                    alert("Error: Not a valid address!");
                }
            });
        }

    }
</script>