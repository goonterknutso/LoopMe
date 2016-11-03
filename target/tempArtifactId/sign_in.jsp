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

<!-- BOOTSTRAP SCRIPTS -->
<%@ include file="templates/bootstrap_scripts.jsp" %>

<!-- GOOGLE MAPS API KEY SCRIPT-->
<%@ include file="js/google_maps_api_key.jsp" %>

<!-- GOOGLE MAPS BACKGROUND SCRIPT -->
<%@ include file="js/google_maps_background.jsp" %>

<!-- FIREBASE SCRIPT -->
<%@ include file="js/firebase_config.jsp" %>

<!-- FIREBASE AUTH SCRIPTS -->
<%@ include file="js/email_sign_in.jsp" %>
<%@ include file="js/email_sign_up.jsp" %>
<%@ include file="js/google_sign_in.jsp" %>
<%@ include file="js/sign_out.jsp" %>
