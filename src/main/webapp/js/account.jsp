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
</script>