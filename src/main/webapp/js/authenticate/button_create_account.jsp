<script>
    document.getElementById("btnCreateAccount").addEventListener("click", createAccount);

    //Sign Up Function
    function createAccount() {
        sessionStorage.setItem("createAccount", true);
        var email = document.getElementById("inputEmail").value;
        var password = document.getElementById("inputPassword").value;

        firebase.auth().createUserWithEmailAndPassword(email, password).catch(function (error) {
            sessionStorage.setItem("createAccount", false);
            // Handle Errors here.
            alert("Error: " + error.message + "!");
        });
    };
</script>