<script>
    function loadData() {
        if (sessionStorage.getItem("email") != null) {
            document.getElementById("inputEmail").value = sessionStorage.getItem("email");
        } else{
            document.getElementById("inputEmail").focus();
        }
        if (sessionStorage.getItem("password") != null) {
            document.getElementById("inputPassword").value = sessionStorage.getItem("password");
            document.getElementById("inputPassword").focus();
        } else {
            document.getElementById("inputPassword").focus();
        }
    }
</script>