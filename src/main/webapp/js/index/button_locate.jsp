<script>
document.getElementById("btnLocation").addEventListener("click", findLocation);

function findLocation(){
    //Find User
    if (navigator.geolocation) {
        var timeoutVal = 10 * 1000 * 1000;
        navigator.geolocation.getCurrentPosition(
                displayUserLocationMap,
                displayDefaultMap,
                {enableHighAccuracy: true, timeout: timeoutVal, maximumAge: 0}
        );
    }
    else {
        alert("Geolocation is not supported by this browser");
    }

    //User doens't allow location
    function displayDefaultMap(error) {

        //Store position
        sessionStorage.removeItem("lat");
        sessionStorage.removeItem("lng");
        alert("Error: Location settings are not enabled. Please enable location settings for your browser and click the button again.");
        // Create a map object and specify the DOM element for display.
        var map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: 38.897540, lng: -77.036958},
            scrollwheel: false,
            zoom: 13
        });
    }

    //User allows location
    function displayUserLocationMap(position) {

        //Store position
        sessionStorage.setItem("lat", position.coords.latitude);
        sessionStorage.setItem("lng", position.coords.longitude);
        // Create a map object and specify the DOM element for display.
        var map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: position.coords.latitude, lng: position.coords.longitude},
            scrollwheel: false,
            zoom: 13
        });

        //Set input field
        if (sessionStorage.getItem("address") == null) {
            var latlng = {lat: position.coords.latitude, lng: position.coords.longitude};
            var geocoder = new google.maps.Geocoder();
            geocoder.geocode({'location': latlng}, function (results, status) {
                if (status === 'OK') {
                    if (results[1]) {
                        sessionStorage.setItem("address", results[1].formatted_address.toString());
                        document.getElementById("inputLocation").value = results[1].formatted_address.toString();
                    } else {
                        alert("Error: Address for location not found!");
                    }
                } else {
                    alert("Error: Geocoder failed due to: " + status + "!");
                }
            });
        } else {
            document.getElementById("inputLocation").value = sessionStorage.getItem("address");
        }
    }
}
</script>
