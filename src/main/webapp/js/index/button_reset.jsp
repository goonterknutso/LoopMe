<script>
    document.getElementById("btnReset").addEventListener("click", resetForm);

    function resetForm(){

        alert("Reset button clicked");

        document.getElementById("inputLocation").value = "";
        document.getElementById("inputDistance").value = "";
    }
</script>