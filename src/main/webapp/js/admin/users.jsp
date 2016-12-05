<script>
    function editOnClick(div) {
        var elementId = div.id;
        var value = div.innerHTML;
        var parent = div.parentNode;
        div.parentNode.removeChild(div);

        var input = document.createElement("INPUT");
        input.setAttribute("type","text");
        input.setAttribute("id",elementId);
        input.setAttribute("value",value.trim());
        input.setAttribute("onblur","editOnBlur(this);");


        parent.appendChild(input);
        document.getElementById(elementId).focus();
    }

    function editOnBlur(input){
        var elementId = input.id;
        var value = input.value;
        var parent = input.parentNode;
        input.parentNode.removeChild(input);
        var div = document.createElement("DIV");
        div.setAttribute("type","text");
        div.setAttribute("id",elementId);
        div.innerHTML = value;
        div.setAttribute("onclick","editOnClick(this);");
        parent.appendChild(div);
    };

    function updateUser(icon){
        //Read in values
        var id = icon.name;

        var email = document.getElementById(id+'email');
        var name = document.getElementById(id+'name');
        var photoUrl = document.getElementById(id+'photoUrl');
        var uid = document.getElementById(id+'uid');
        var role = document.getElementById(id+'role');
        var address = document.getElementById(id+'address');
        var gps = document.getElementById(id+'gps');
        var numLoops = document.getElementById(id+'numLoops');

        //Redirect to servlet with params
        window.location.href="/updateUser";

    }

    function deleteUser(){

    }
</script>