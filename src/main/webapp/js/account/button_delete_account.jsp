<script>
    document.getElementById("btnDeleteAccount").addEventListener("click", function(){

        var user = firebase.auth().currentUser;

        if (confirm('Are you sure you want to delete your account? All of your saved loops and preferences will be lost!')) {

            // Prompt the user to re-provide their sign-in credentials
            var credentialPass = prompt("Enter your password: ");
            var credential = firebase.auth.EmailAuthProvider.credential(
                    user.email,
                    credentialPass
            );

            user.reauthenticate(credential).then(function() {
                // User re-authenticated.
                user.delete().then(function() {
                    // User deleted.
                    sessionStorage.setItem("delete", true);
                    sessionStorage.setItem("deleteUid", user.uid);
                }, function(error) {
                    // An error happened.
                    alert("Error: "+error.message);
                });
            }, function(error) {
                // An error happened.
                alert("Error: "+error.message);
            });

        }
    });
</script>
