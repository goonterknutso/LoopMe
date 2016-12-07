<%@ page import="com.google.maps.model.LatLng" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.excerloops.entity.User" %>
<script>
    <%
    //Get Request Attributes
    String address = (String) request.getAttribute("address");
    LatLng startLatLng = (LatLng) request.getAttribute("startLatLng");
    double distance = (Double) request.getAttribute("distance");
    String unit = (String) request.getAttribute("unit");

    ArrayList<LatLng> waypoints = (ArrayList<LatLng>) request.getAttribute("waypoints");
    int numMarkers = (Integer) request.getAttribute("numMarkers");
    ArrayList<LatLng> markers = (ArrayList<LatLng>) request.getAttribute("markers");
    int zoom = (Integer) request.getAttribute("zoom");
    int lineColor = (Integer) request.getAttribute("lineColor");
    String hexColor = String.format("#%06X", (0xFFFFFF & lineColor));

    String transitMode = (String) request.getAttribute("transitMode");
    String tm;
    if(transitMode.equals("RUN")){
        tm = "WALKING";
    } else if(transitMode.equals("BIKE")){
        tm = "BICYCLING";
    } else {
        tm = "DRIVING";
    }


    //Alert if loop added successfully or not
    if(session.getAttribute("loopAdded") != null){
        if((Boolean)session.getAttribute("loopAdded")){
            %> alert("Loop added."); <%
            session.removeAttribute("loopAdded");
        } else {
            %> alert("Error: Something went wrong while adding the loop. Please contact the administrator."); <%
            session.removeAttribute("loopAdded");
        }
    }
    %>


    
    function displayGeneratedMap() {
        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer({
            polylineOptions: {
                strokeColor: '<% out.print(hexColor); %>'
            },
            suppressMarkers:true
        });
        
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: <%= zoom %> ,
            center: {lat: <%= startLatLng.lat %>,
                     lng: <%= startLatLng.lng %>}
        });
        directionsDisplay.setMap(map);

        //Display starting marker
        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(<%= startLatLng.toString() %>),
            map: map,
            title: 'Start',
        });

        //Display additional markers
        <% for(int i = 0; i < markers.size(); i++){ %>
        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(<%= markers.get(i).toString() %>),
            map: map,
            label: '<%= i+1 %>'
        });
        <% } %>

        //google.maps.SymbolPath.BACKWARD_CLOSED_ARROW



        calculateAndDisplayRoute(directionsService, directionsDisplay);
    }

    function calculateAndDisplayRoute(directionsService, directionsDisplay) {
        var waypts = [];

        <% for(int i = 0; i< waypoints.size(); i++){ %>
            waypts.push({
                location: new google.maps.LatLng(<%= waypoints.get(i).toString() %>),
                stopover: true
            });
        <% } %>



        directionsService.route({
            origin: new google.maps.LatLng(<%= startLatLng.toString() %>),
            destination: new google.maps.LatLng(<%= startLatLng.toString() %>),
            waypoints: waypts,
            optimizeWaypoints: true,
            travelMode: '<% out.print(tm); %>'
        }, function(response, status) {
            if (status === 'OK') {
                directionsDisplay.setDirections(response);
                var route = response.routes[0];
                var totalDist = 0;

                for (var i = 0; i < route.legs.length; i++) {
                    totalDist += route.legs[i].distance.value;
                }

                //Set distKM
                document.getElementById("distKM").innerHTML = (totalDist/1000).toFixed(2) + " KM";
                document.getElementById("distKM").value = (totalDist/1000).toFixed(2);
                //Set distMI
                document.getElementById("distMI").innerHTML = (totalDist/1000*0.621371).toFixed(2) + " MI";
                document.getElementById("distMI").value = (totalDist/1000*0.621371).toFixed(2);


            } else {
                //Try Again
                window.location.href = '<%= request.getAttribute("url") %>';
            }
        });
    }

</script>