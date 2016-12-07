<script>
    document.getElementById("btnSave").addEventListener("click", function(){

        //Check to see if user is logged in
        if(firebase.auth().currentUser === null){
            alert("Error: You must be signed in to use this feature.");
        } else {
            //Prompt For Name
            var name = prompt("Enter a name for the loop: ");

            //Name is Empty
            if (name === "") {
                alert("Error: Loop must have a name.");
            }
            //Cancel Clicked
            else if (name === null){
                return;
            }
            //Name OK
            else {
                var user = firebase.auth().currentUser;

                var resultsLat = new Array();
                var resultsLng = new Array();

                <% for(int i = 0; i<waypoints.size(); i++){ %>
                    resultsLat.push(<%= waypoints.get(i).lat %>);
                    resultsLng.push(<%= waypoints.get(i).lng %>);
                <% } %>


                window.location.href = "/saveLoop?name=" + name +
                        "&startAddress=" + '<%= address %>' +
                        "&startLat=" + '<%= startLatLng.lat %>' +
                        "&startLng=" + '<%= startLatLng.lng %>' +
                        "&inputDistance=" + '<%= distance %>' +
                        "&distanceKM=" + document.getElementById("distKM").value +
                        "&distanceMI=" + document.getElementById("distMI").value +
                        "&unit=" + '<%= unit %>' +
                        "&transitMode=" + '<%= transitMode %>' +
                        "&zoom=" + '<%= zoom %>' +
                        "&uid=" + user.uid +
                        "&resultsLat=" + resultsLat +
                        "&resultsLng=" + resultsLng;
            }
        }

    });
</script>