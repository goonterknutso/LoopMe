<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--NAVBAR-->
<div class="navbar navbar-inverse navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index" id="logo">ExcerLoops</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li id="navCreateLoop"><a href="/index">Home</a></li>
                <li id="navHowItWorks"><a href="/howItWorks">How it Works</a></li>
                <li id="navAbout"><a href="/about">About</a></li>
                <li id="navContact"><a href="/contact">Contact</a></li>
                <li id="navAccountSettings">
                    <% if(session.getAttribute("user")==null) { %>
                    <a href="/signIn">Sign In</a></li>
                    <% } else { %>
                    <a href="/account">Account</a></li>
                    <% }  %>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

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