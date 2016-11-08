<!--SIGN_IN.JSP -->
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Head JSP Template -->
        <%@include file = "templates/head.jsp" %>
        <!-- Custom Page CSS -->
        <link href="resources/styles/sign_in.css" type="text/css" rel="stylesheet"/>
        <link href="resources/styles/bootstrap-social.css" type="text/css" rel="stylesheet"/>
        <link href="resources/styles/bootstrap-social.css" type="text/css" rel="stylesheet"/>
    </head>

    <body onload="displayBackgroundMap()">
        <!-- Navbar JSP Template -->
        <%@ include file ="templates/navbar.jsp" %>
        <!-- Main Page Content -->
        <%@ include file="templates/main/sign_in_main_content.jsp" %>
        <!-- Footer JSP Templates -->
        <%@ include file = "templates/footer.jsp" %>
    </body>

</html>

<!-- CONFIG SCRIPTS -->
<%@ include file="templates/config/firebase_config.jsp" %>
<%@ include file="templates/config/bootstrap_scripts.jsp" %>
<%@ include file="templates/config/google_maps_api_key.jsp" %>

<!-- CUSTOM PAGE SCRIPTS -->
<%@ include file="js/authentication.jsp" %>
<script src="js/google_maps_background.js"></script>
<script src="js/sign_out.js"></script>
<script src="js/authentication.jsp"></script>
