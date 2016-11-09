<script>
    document.getElementById("btnSignOut").addEventListener("click", signOut);

    function signOut() {
        firebase.auth().signOut().then(function () {
            alert("Sign Out Successful");

            //Add in servlet call
            window.location.href = "/signOutAuth";
            alert("no?");

        }, function (error) {
            var errorCode = error.code;
            var errorMessage = error.message;

            alert("Error Code: " + errorCode + "\n" +
                    "Error Message: " + errorMessage);
        });
        alert("here");
        window.location.href="/signOutAuth";
    }
</script>
