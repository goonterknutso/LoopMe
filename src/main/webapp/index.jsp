<!-- INDEX.JSP -->
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Head JSP Template -->
        <%@include file = "templates/head.jsp" %>
        <!-- Custom Page CSS -->
        <style><%@include file = "resources/styles/index.css"%></style>
    </head>

    <body>
        <!-- Navbar JSP Template -->
        <%@ include file ="templates/navbar.jsp" %>
        <!-- Main Page Content -->
        <div id="wrapper">
            <!-- Map -->
            <div id="map" style="width:100%;height:900px;"></div>

            <!-- Form on Top of Map -->
            <div id="over_map">
                <div class="container-fluid">
                    <!-- FORM -->
                    <form>

                        <legend>Create a Loop</legend>

                        <!-- LOCATION INPUT -->
                        <div class="form-group row">
                            <label for="inputLocation" class="col-sm-12 col-form-label">Location:</label>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <input type="text" class="form-control" id="inputLocation" placeholder="Enter an address or GPS location here!">
                            </div>
                        </div>

                        <!-- DISTANCE INPUT -->
                        <div class="form-group row">
                            <label for="inputDistance" class="col-sm-12 col-form-label">Distance:</label>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="inputDistance" placeholder="Enter a distance here!">
                            </div>
                            <div class="col-sm-4">
                                <select class="form-control" id="exampleSelect1">
                                    <option>MI</option>
                                    <option>KM</option>
                                </select>
                            </div>
                        </div>

                        <!--SUBMIT AND CLEAR BUTTONS -->
                        <div class="form-group row" id="div_buttons">
                            <div class="btn-group" role="group" aria-label="...">
                            <button  type="submit" class="btn btn-primary btn-block">Submit</button>
                            <button id="button_clear" type="submit" class="btn btn-secondary btn-block">Clear</button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
        <!-- Footer JSP Templates -->
        <%@ include file = "templates/footer.jsp" %>
    </body>

</html>

<!-- BOOTSTRAP SCRIPTS -->
<%@ include file="templates/bootstrap_scripts.jsp" %>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB6GLTECvlfDuCR9HCVRN5xKmm0ca3RHV0"></script>
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