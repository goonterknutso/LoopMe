<script>
    function setupDeleteButtons() {
        var iconButtons = document.getElementsByName('deleteIcons');
        for (var i = 0; i < iconButtons.length; i++) {
            iconButtons[i].addEventListener("click", deleteSavedLoop);
            iconButtons[i].addEventListener("mouseover", onDeleteMouseOver);
            iconButtons[i].addEventListener("mouseout", onDeleteMouseOut);

        }

        function deleteSavedLoop() {
            var id = this.id;

            if(confirm("Are you sure you would like to delete loop " + document.getElementById(id).value +"?")){
                window.location.href = "/deleteLoop?id="+id+"&uid="+firebase.auth().currentUser.uid;
            }

        }

        function onDeleteMouseOver() {
            this.style.color="red";
            this.title = "Click here to delete saved loop!";
        }

        function onDeleteMouseOut() {
            this.style.color="";
        }
    }
</script>
