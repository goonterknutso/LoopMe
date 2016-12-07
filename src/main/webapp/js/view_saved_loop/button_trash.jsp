<script>
    document.getElementById("btnTrash").addEventListener("click", function(){
        var uid = firebase.auth().currentUser.uid;
        var id = '<%= request.getAttribute("id") %>';

        window.location.href = "/deleteLoop?id="+id+"&uid="+uid;
    });
</script>