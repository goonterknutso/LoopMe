<script>
document.getElementById("btnLocation").addEventListener("click", function(){
    alert("Find me clicked");
    sessionStorage.setItem("findMeClicked", true);

    alert(sessionStorage.getItem("permissionDenied"));
    if(sessionStorage.getItem("permissionDenied")) {

        alert("permission denied");




        if (sessionStorage.getItem("reset")) {
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
    }
});
</script>
