<script>
    document.addEventListener("keydown", keyDownTextField, false);

    function keyDownTextField(e) {
        var keyCode = e.keyCode;
        if(keyCode==13) {
            signIn();
        }
    }
</script>