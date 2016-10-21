<!-- INDEX.JSP -->

<!DOCTYPE html>

<html lang="en">
<head>
    <%@include file = "templates/head.jsp" %>
    <title>Create Loop</title>
</head>


<body>

<!-- NAVBAR -->
<%@ include file ="templates/navbar.jsp" %>

<!-- MAIN CONTENT -->
<div id="map" style="width:100%;height:700px"></div>

<script>

    if (navigator.geolocation) {
        var timeoutVal = 10 * 1000 * 1000;
        navigator.geolocation.getCurrentPosition(
                initMap,
                displayError,
                { enableHighAccuracy: true, timeout: timeoutVal, maximumAge: 0 }
        );
    }
    else {
        alert("Geolocation is not supported by this browser");
    }

    function displayError(error) {
        var errors = {
            1: 'Permission denied',
            2: 'Position unavailable',
            3: 'Request timeout'
        };
        alert("Error: " + errors[error.code]);
    }

    function initMap(position) {
        // Create a map object and specify the DOM element for display.
        var map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: position.coords.latitude, lng: position.coords.longitude},
            scrollwheel: false,
            zoom: 13
        });
    }

</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB6GLTECvlfDuCR9HCVRN5xKmm0ca3RHV0"></script>

<!-- BOOTSTRAP SCRIPTS -->
<%@ include file="templates/bootstrap_scripts.jsp" %>

</body>
</html>

