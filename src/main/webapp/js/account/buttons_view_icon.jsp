<script>
    function setupViewButtons() {
        var iconButtons = document.getElementsByName('viewIcons');
        for (var i = 0; i < iconButtons.length; i++) {
            iconButtons[i].addEventListener("click", viewSavedLoop);
            iconButtons[i].addEventListener("mouseover", onViewMouseOver);
            iconButtons[i].addEventListener("mouseout", onViewMouseOut);
        }

        function viewSavedLoop() {
            var id = this.id;

            window.location.href = "/viewLoop?id="+id+"&uid="+firebase.auth().currentUser.uid;
        }

        function onViewMouseOver() {
            this.style.color="yellow";
            this.title = "Click here to delete saved loop!";
        }

        function onViewMouseOut() {
            this.style.color="";
        }

    }
</script>
