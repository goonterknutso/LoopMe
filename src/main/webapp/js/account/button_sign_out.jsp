<script>
    document.getElementById("btnSignOut").addEventListener("click", signOut);

    function signOut() {
        sessionStorage.setItem("delete", false);
        firebase.auth().signOut().then(function () {
            sessionStorage.setItem("signOut", true);
        }, function (error) {
            alert("Error: " + error.message);
        });
    }
</script>
