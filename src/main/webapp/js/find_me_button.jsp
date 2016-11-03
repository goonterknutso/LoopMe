<script>
    document.getElementById("btnLocation").addEventListener("click", function(){

        console.log("Location button clicked");

        sessionStorage.setItem("findMeClicked", true);

        if(sessionStorage.getItem("reset")){
            console.log("Resetting and reloading");
            sessionStorage.removeItem("lat");
            sessionStorage.removeItem("lng");
            sessionStorage.removeItem("address");
            sessionStorage.removeItem("reset");
            sessionStorage.removeItem("findMeClicked");
            sessionStorage.removeItem("permissionDenied");
            window.location.reload();
        } else {
            displayBackgroundMap();
        }
    });
</script>