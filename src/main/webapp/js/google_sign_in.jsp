<script>
    document.getElementById("btnGoogle").addEventListener("click", googleSignIn);

    function googleSignIn() {
        console.log("Google Button Clicked");

        var provider = new firebase.auth.GoogleAuthProvider();

        firebase.auth().signInWithRedirect(provider);
        provider.addScope('472921258906-l2kianp36gmjkihnlthjrlc6r6h7qk5t.apps.googleusercontent.com');

        firebase.auth().getRedirectResult().then(function(result) {
            if (result.credential) {
                // This gives you a Google Access Token. You can use it to access the Google API.
                var token = result.credential.accessToken;
                // ...
            }
            // The signed-in user info.
            var user = result.user;
        }).catch(function(error) {
            // Handle Errors here.
            var errorCode = error.code;
            var errorMessage = error.message;
            // The email of the user's account used.
            var email = error.email;
            // The firebase.auth.AuthCredential type that was used.
            var credential = error.credential;

            console.log("Error Code: "+errorCode);
            console.log("Error Message: "+errorMessage);
            console.log("Error Email: "+email);
            console.log("Error Credential: "+credential);
        });
    }
</script>