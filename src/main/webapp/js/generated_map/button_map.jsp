<script>
    document.getElementById("btnMap").addEventListener("click", function(){
        window.open('<% out.print((String) request.getAttribute("mapsUri")); %>', '_blank');
    });
</script>