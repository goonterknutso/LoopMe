<script>
    document.getElementById("btnSubmit").addEventListener("click", generateLoops);

    function generateLoops(){

        alert("Submit button clicked");

        var locationVerified = false;
        var distanceVerified = false;

        var lat = "";
        var lng = "";

        //Check address input
        var address = document.getElementById("inputLocation").value;
        if(address == ""){
            alert("Error: Address cannot be empty!");
        } else {
            var geocoder = new google.maps.Geocoder();
            geocoder.geocode({'address': address}, function (results, status) {
                if (status === 'OK') {
                    locationVerified = true;
                    lat = results[1].latitude;
                    lng = results[1].longitude;
                    alert("LatLng: "+lat+" "+lng);
                 } else {
                    alert("Error: Not a valid address!");
                }
            });
        }

        //Check distance
        var distance = document.getElementById("inputDistance").value;
        if(distance == ""){
            alert("Error: Distance cannot be empty!");
        } else if(isNaN(distance)) {
            alert("Error: Distance must be a number!");
        } else {
            distanceVerified = true;
        }

        //Get unit
        var unit = document.getElementById("inputDistanceUnit").value;

        if(locationVerified && distanceVerified){
            alert("Location: "+address);
            alert("LatLng: "+lat+","+lng);
            alert("Distance: "+distance);
            alert("Unit: "+unit);
        }
    }
</script>