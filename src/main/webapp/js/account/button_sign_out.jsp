<script>
    document.getElementById("btnSignOut").addEventListener("click", signOut);

    function signOut() {
        firebase.auth().signOut().then(function () {
            sessionStorage.setItem("signOut", true);
        }, function (error) {
            alert("Error: " + error.message + "!");
        });

    }

    //Listen for change in user
    firebase.auth().onAuthStateChanged(function(user) {
        if(user==null) {
            window.location.href = "/signOutAuth";
        }
    });
</script>
