<script>
    //Listen for change in user
    firebase.auth().onAuthStateChanged(function(user) {
        if(user==null) {
            if(sessionStorage.getItem("delete") == true){
                sessionStorage.setItem("delete", false);
                window.location.href = "/deleteUser?uid="+sessionStorage.getItem("deleteUid");
            } else {
                window.location.href = "/signOutAuth";
            }
        }
    });
</script>