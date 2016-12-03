<script>
    document.getElementById("btnResetPreferences").addEventListener("click", function(){
        //Default Preferences

        //Home Enabled
        document.getElementById("homeEnabledFalse").checked = true;
        document.getElementById("inputDefaultHome").disabled = true;
        document.getElementById("homeEnabledFalseLabel").style.color = "red";
        document.getElementById("homeEnabledTrueLabel").style.color = "";
        //Home
        document.getElementById("inputDefaultHome").value = "";


        //Unit Enabled
        document.getElementById("unitEnabledFalse").checked = true;
        document.getElementById("selectUnit").disabled = true;
        document.getElementById("unitEnabledFalseLabel").style.color = "red";
        document.getElementById("unitEnabledTrueLabel").style.color = "";
        //Unit
        document.getElementById("selectUnit").value = "MI";

        //Line Color
        document.getElementById("selectColor").value = "-16776961";
        document.getElementById("selectColor").style.color = "white";
        document.getElementById("selectColor").style.backgroundColor = "blue";

        //Transit Mode
        document.getElementById("selectTransit").value = "RUN";

        //Number of Markers
        document.getElementById("inputNumMarkers").value = "5";
    });
</script>