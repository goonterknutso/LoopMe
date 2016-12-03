<script>
    //User Change Function
    firebase.auth().onAuthStateChanged(function(user) {
        if (user) {
            if(sessionStorage.getItem("createAccount")){
                sessionStorage.removeItem("createAccount");
                window.location.href = "/signUpAuth?email="+user.email+
                        "&name="+user.displayName+
                        "&photoUrl="+user.photoUrl+
                        "&uid="+user.uid;
            }
            else {
                window.location.href = "/signInAuth?uid="+user.uid;
            }
        }
    });
</script>