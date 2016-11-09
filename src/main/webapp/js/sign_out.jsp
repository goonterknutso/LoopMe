<script>
    document.getElementById("btnSignOut").addEventListener("click", signOut);

    function signOut() {
        firebase.auth().signOut().then(function () {
            //alert("Sign Out Successful");
            sessionStorage.setItem("signOut", true);
        }, function (error) {
            var errorCode = error.code;
            var errorMessage = error.message;

            alert("Error Code: " + errorCode + "\n" +
                    "Error Message: " + errorMessage);
        });

    }

    //Listen for change in user
    firebase.auth().onAuthStateChanged(function(user) {
        if(user==null) {
            window.location.href = "/signOutAuth";
        }
    });
</script>
