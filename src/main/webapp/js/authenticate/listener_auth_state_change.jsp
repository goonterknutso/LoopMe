<script>
    //User Change Function
    firebase.auth().onAuthStateChanged(function(user) {
        if (user) {
            sessionStorage.removeItem("password");

            //Create Account
            if(sessionStorage.getItem("createAccount")){
                sessionStorage.removeItem("createAccount");
                sessionStorage.setItem("email", user.email);
                window.location.href = "/createUser?email="+user.email+
                        "&name="+user.displayName+
                        "&photoUrl="+user.photoUrl+
                        "&uid="+user.uid+
                        "&googleSignIn=false";
            }
            //Google Sign, Try to Create Account, Servlet Handles if User Exists
            else if(sessionStorage.getItem("googleSignIn")){
                sessionStorage.removeItem("googleSignIn");
                sessionStorage.removeItem("email");

                window.location.href = "/createUser?email="+user.email+
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