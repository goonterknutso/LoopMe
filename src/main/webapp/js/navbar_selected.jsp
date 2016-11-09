<script type="text/javascript">

    if(document.URL.indexOf("index")>0){
        document.getElementById("navCreateLoop").className = "active";
    }
    else if(document.URL.indexOf("how_it_works")>0){
        document.getElementById("navHowItWorks").className = "active";
    }
    else if(document.URL.indexOf("about")>0){
        document.getElementById("navAbout").className = "active";
    }
    else if(document.URL.indexOf("contact")>0){
        document.getElementById("navContact").className = "active";
    }
    else if(document.URL.indexOf("account")>0 || document.URL.indexOf("sign")>0){
        document.getElementById("navAccountSettings").className = "active";
    }
    else {
        document.getElementById("navCreateLoop").className = "active";
    }
</script>