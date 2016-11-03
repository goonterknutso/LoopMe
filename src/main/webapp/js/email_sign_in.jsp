<script>

    document.getElementById("btnSignIn").addEventListener("click", signUp);

    function signUp() {
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

    }

</script>