<%--
  Created by IntelliJ IDEA.
  User: gunther
  Date: 9/25/16
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#" id="logo">LoopMe</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li id="navCreateLoop"><a href="#">Create Loop</a></li>
                <li>|</li>
                <li id="navHowItWorks"><a href="#how_it_works">How it Works</a></li>
                <li>|</li>
                <li id="navAbout"><a href="#about">About</a></li>
                <li>|</li>
                <li id="navContact"><a href="#contact">Contact</a></li>
                <li>|</li>
                <li id="navAccountSettings"><a href="#account_settings">Account</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<script type="text/javascript">
    if(document.URL.contains("index")){
        document.getElementById("navCreateLoop").class = "active";
    }
    else if(document.URL.contains("createloop")){
        document.getElementById("navCreateLoop").class = "active";
    }
    else if(document.URL.contains("index")){
        document.getElementById("navHowItWorks").class = "active";
    }
    else if(document.URL.contains("index")){
        document.getElementById("navAbout").class = "active";
    }
    else if(document.URL.contains("index")){
        document.getElementById("navContact").class = "active";
    }
    else if(document.URL.contains("index")){
        document.getElementById("navAccountSettings").class = "active";
    }



</script>
