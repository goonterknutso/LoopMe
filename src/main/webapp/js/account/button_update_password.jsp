<script>
    document.getElementById("btnUpdatePassword").addEventListener("click", function() {
        var newPassword = document.getElementById("inputPassword").value;
        var confPassword = document.getElementById("inputConfirmPassword").value;

        //Passwords match
        if (newPassword == confPassword) {
            var user = firebase.auth().currentUser;

            user.updatePassword(newPassword).then(function () {
                // Update successful.
                alert("Success: Password updated!");
                newPassword.value ="";
                confPassword.value="";
            }, function (error) {
                // An error happened.
                alert("Error: "+error.message + "!");
            });
        }

        //Passwords don't match
        else {
            alert("Error: Passwords don't match!");
        }
    });
</script>