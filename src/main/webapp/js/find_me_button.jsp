<script>
    document.getElementById("btnLocation").addEventListener("click", function(){

        console.log("Location button clicked");

        if(sessionStorage.getItem("reset")){
            console.log("Resetting and reloading");
            sessionStorage.removeItem("lat");
            sessionStorage.removeItem("lng");
            sessionStorage.removeItem("address");
            sessionStorage.removeItem("reset");
            window.location.reload();
        } else {
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
                alert("Error: Location settings are not enabled. Please enable them for your browser.");
                sessionStorage.setItem("reset", true);
                //Store position
                sessionStorage.setItem("lat", 38.897540);
                sessionStorage.setItem("lng", -77.036958);

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
                if(sessionStorage.getItem("address")==null) {
                    console.log("Retrieving address");
                    var latlng = {lat: position.coords.latitude, lng: position.coords.longitude};
                    var geocoder = new google.maps.Geocoder();
                    geocoder.geocode({'location': latlng}, function (results, status) {
                        if (status === 'OK') {
                            if (results[1]) {
                                sessionStorage.setItem("address", results[1].formatted_address.toString());
                                document.getElementById("inputLocation").value = results[1].formatted_address.toString();
                            } else {
                                alert("No results found");
                            }
                        } else {
                            alert("Gedocoder failed due to: " + status);
                        }
                    });
                } else {
                    console.log("Using stored address");
                    document.getElementById("inputLocation").value = sessionStorage.getItem("address");
                }
            }
        }
    });
</script>