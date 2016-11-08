document.getElementById("btnSignIn").addEventListener("click", signIn);
document.getElementById("btnSignUp").addEventListener("click", signUp);
document.getElementById("btnGoogle").addEventListener("click", googleSignIn);


function signIn() {
    signOut();
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

function signUp() {
    alert("Sign Up Butotn clicked");


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

function googleSignIn() {
    signOut();
    alert("Google Button Clicked");

    var provider = new firebase.auth.GoogleAuthProvider();

    firebase.auth().signInWithRedirect(provider);

    firebase.auth().getRedirectResult().then(function(result) {
        if (result.credential) {
            // This gives you a Google Access Token. You can use it to access the Google API.
            var token = result.credential.accessToken;
            alert("it worked?");
        }
        // The signed-in user info.
        var user = result.user;
        alert(user);
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
}

//User status has changed
firebase.auth().onAuthStateChanged(function(user) {
    if (user) {
        var name, email, photoUrl, uid;

        name = user.displayName;
        email = user.email;
        photoUrl = user.photoURL;
        uid = user.uid;  // The user's ID, unique to the Firebase project. Do NOT use
                         // this value to authenticate with your backend server, if
                         // you have one. Use User.getToken() instead.

        alert(name + "\n" + email + "\n" + photoUrl + "uid");
    } else {
        alert("No user signed in");
    }
});