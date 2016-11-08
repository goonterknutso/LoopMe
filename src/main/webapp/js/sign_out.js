
function signOut() {
    firebase.auth().signOut().then(function () {
        alert("Sign Out Successful");
    }, function (error) {
        var errorCode = error.code;
        var errorMessage = error.message;

        alert("Error Code: " + errorCode + "\n" +
                "Error Message: " + errorMessage);
    });
}
