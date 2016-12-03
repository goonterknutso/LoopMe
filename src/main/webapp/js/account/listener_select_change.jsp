<script>
document.getElementById("selectColor").addEventListener("change", function(){

    var val = this[this.selectedIndex].value;
    
    switch(val){
        case "-65281": this.style.color = "black"; this.style.backgroundColor = "magenta"; break;
        case "-16776961": this.style.color = "white"; this.style.backgroundColor = "blue"; break;
        case "-16711681": this.style.color = "black"; this.style.backgroundColor = "cyan"; break;
        case "-16711936": this.style.color = "white"; this.style.backgroundColor = "green"; break;
        case "-256": this.style.color = "black"; this.style.backgroundColor = "yellow"; break;
        case "-65536": this.style.color = "white"; this.style.backgroundColor = "red"; break;
        case "-16777216": this.style.color = "white"; this.style.backgroundColor = "black"; break;
        case "-1": this.style.color = "black"; this.style.backgroundColor = "white"; break;
    }
});

</script>
