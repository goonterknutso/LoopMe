<script>
    document.getElementById("btnSignIn").addEventListener("click", signIn);
    document.getElementById("btnSignUp").addEventListener("click", signUp);
    document.getElementById("btnGoogle").addEventListener("click", googleSignIn);


    function signIn() {
        alert("Sign In Button Clicked");

        var email = document.getElementById("inputEmail").value;
        var password = document.getElementById("inputPassword").value;

        firebase.auth().signInWithEmailAndPassword(email, password).catch(function (error) {
            // Handle Errors here.
            var errorCode = error.code;
            var errorMessage = error.message;
            alert("Error Code: " + errorCode + "\n" +
                "Error Message: " + errorMessage);
        });
    };


    function signUp() {
        alert("Sign Up Button clicked");
        sessionStorage.setItem("signUp", true);
        var email = document.getElementById("inputEmail").value;
        var password = document.getElementById("inputPassword").value;

        firebase.auth().createUserWithEmailAndPassword(email, password).catch(function (error) {
            // Handle Errors here.
            var errorCode = error.code;
            var errorMessage = error.message;

            alert("Error Code: " + errorCode + "\n" +
                "Error Message: " + errorMessage);
        });
    };


    function googleSignIn() {
        alert("Google Button Clicked");

        var provider = new firebase.auth.GoogleAuthProvider();

        firebase.auth().signInWithRedirect(provider);

        firebase.auth().getRedirectResult().then(function(result) {
            if (result.credential) {
                // This gives you a Google Access Token. You can use it to access the Google API.
                var token = result.credential.accessToken;
            }
            // The signed-in user info.
            var user = result.user;
            alert("User:"+user);
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
    };

    //Listen for change in user
    firebase.auth().onAuthStateChanged(function(user) {
        alert("onAuthStateChanged");

        if (user) {
            if(sessionStorage.getItem("signUp")){
                alert("sign up");
                sessionStorage.removeItem("signUp");
                window.location.href = "/signUpAuth?email="+user.email+
                        "&name="+user.displayName+
                        "&photoUrl="+user.photoUrl+
                        "&uid="+user.uid;
            } else {
                alert("sign in");
                window.location.href = "/signInAuth?email="+user.email;
            }


        }

    });



</script>