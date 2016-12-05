<script>
    document.getElementById("btnSignIn").addEventListener("click", signIn);

    //Sign In Function
    function signIn() {

        var email = document.getElementById("inputEmail").value;
        var password = document.getElementById("inputPassword").value;

        sessionStorage.setItem("email", email);
        sessionStorage.setItem("password", password);

        firebase.auth().signInWithEmailAndPassword(email, password).catch(function (error) {
            // Handle Errors here.
            alert("Error: " + error.message + "!");
        });
    };
</script>
