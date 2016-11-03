<script>

    document.getElementById("btnSignUp").addEventListener("click", createUser);

    function createUser() {
        console.log("Sign Up Button Clicked");

        var btnSignUp = document.getElementById("btnSignUp");

        var email = document.getElementById("inputEmail").value;
        var password = document.getElementById("inputPassword").value;

        firebase.auth().createUserWithEmailAndPassword(email, password).catch(function (error) {
            // Handle Errors here.
            var errorCode = error.code;
            var errorMessage = error.message;

            alert("Error Code: " + errorCode + "\n" +
                    "Error Message: " + errorMessage);

        });

    }

</script>
