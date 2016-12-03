<script>
    //User Change Function
    firebase.auth().onAuthStateChanged(function(user) {
        if (user) {
            //Create Account
            if(sessionStorage.getItem("createAccount")){
                sessionStorage.removeItem("createAccount");
                window.location.href = "/signUpAuth?email="+user.email+
                        "&name="+user.displayName+
                        "&photoUrl="+user.photoUrl+
                        "&uid="+user.uid;
            }
            //Google Sign, Try to Create Account, Servlet Handles if User Exists
            else if(sessionStorage.getItem("googleSignIn")){
                sessionStorage.removeItem("googleSignIn");
                window.location.href = "/signUpAuth?email="+user.email+
                        "&name="+user.displayName+
                        "&photoUrl="+user.photoURL+
                        "&uid="+user.uid+
                        "&googleSignIn=true";

            }
            //Sign In
            else {
                window.location.href = "/signInAuth?uid="+user.uid;
            }
        }
    });
</script>