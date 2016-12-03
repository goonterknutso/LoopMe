<script>
    document.getElementById("homeEnabledTrue").addEventListener("click", function(){
        document.getElementById("inputDefaultHome").disabled = false;
        document.getElementById("homeEnabledTrueLabel").style.color = "green";
        document.getElementById("homeEnabledFalseLabel").style.color = "";
    });

    document.getElementById("homeEnabledFalse").addEventListener("click", function(){
        document.getElementById("inputDefaultHome").disabled = true;
        document.getElementById("homeEnabledTrueLabel").style.color = "";
        document.getElementById("homeEnabledFalseLabel").style.color = "red";
    });
</script>