<script>
    document.getElementById("unitEnabledTrue").addEventListener("click", function(){
        document.getElementById("selectUnit").disabled = false;
        document.getElementById("unitEnabledTrueLabel").style.color = "green";
        document.getElementById("unitEnabledFalseLabel").style.color = "";

    });

    document.getElementById("unitEnabledFalse").addEventListener("click", function(){
        document.getElementById("selectUnit").disabled = true;
        document.getElementById("unitEnabledTrueLabel").style.color = "";
        document.getElementById("unitEnabledFalseLabel").style.color = "red";
    });
</script>