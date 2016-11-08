<!-- INDEX.JSP -->
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Head JSP Template -->
        <%@ include file = "templates/head.jsp" %>
        <!-- Custom Page CSS -->
        <style><%@ include file = "resources/styles/index.css"%></style>
    </head>

    <body onload="displayBackgroundMap()">
        <!-- Navbar JSP Template -->
        <%@ include file="templates/navbar.jsp" %>
        <!-- Main Content -->
        <%@ include file="templates/main/index_main_content.jsp" %>
        <!-- Footer JSP Templates -->
        <%@ include file = "templates/footer.jsp" %>
    </body>

</html>

<!-- CONFIG SCRIPTS -->
<%@ include file="templates/config/firebase_config.jsp" %>
<%@ include file="templates/config/bootstrap_scripts.jsp" %>
<%@ include file="templates/config/google_maps_api_key.jsp" %>

<!-- CUSTOM PAGE SCRIPTS -->
<script src="js/google_maps_background.js" type="text/javascript"></script>