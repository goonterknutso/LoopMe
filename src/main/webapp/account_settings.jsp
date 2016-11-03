<!-- ACCOUNT_SETTINGS.JSP -->
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Head JSP Template -->
        <%@include file = "templates/head.jsp" %>
        <!-- Custom Page CSS -->
        <style><%@include file = "resources/styles/account_settings.css"%></style>
    </head>


    <body onload="displayBackgroundMap()">
        <!-- Navbar JSP Template -->
        <%@ include file ="templates/navbar.jsp" %>

        <!-- Main Page Content -->
        <%@ include file="templates/main/account_settings_main_content.jsp" %>

        <!-- Footer JSP Templates -->
        <%@ include file = "templates/footer.jsp" %>
    </body>


    <!-- BOOTSTRAP SCRIPTS -->
    <%@ include file="templates/bootstrap_scripts.jsp" %>

    </body>
</html>

<!-- BOOTSTRAP SCRIPTS -->
<%@ include file="templates/bootstrap_scripts.jsp" %>

<!-- GOOGLE MAPS API KEY SCRIPT-->
<%@ include file="js/google_maps_api_key.jsp" %>

<!-- GOOGLE MAPS BACKGROUND SCRIPT -->
<%@ include file="js/google_maps_background.jsp" %>

