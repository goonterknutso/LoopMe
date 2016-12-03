<!-- INDEX.JSP -->
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Head JSP Template -->
        <%@ include file = "templates/parts/head.jsp" %>
        <!-- Custom Page CSS -->
        <link rel="stylesheet" type="text/css" href="resources/styles/index.css">
    </head>

    <body onload="displayBackgroundMap()">
        <!-- Navbar JSP Template -->
        <%@ include file="templates/parts/navbar.jsp" %>
        <!-- Main Content -->
        <%@ include file="templates/index_main_content.jsp" %>
        <!-- Footer JSP Templates -->
        <%@ include file = "templates/parts/footer.jsp" %>
    </body>

</html>

<!-- CUSTOM PAGE SCRIPTS -->
<%@ include file="js/google_maps_background.jsp" %>
<%@ include file="js/index/button_locate.jsp" %>
<%@ include file="js/index/button_generate.jsp" %>
<%@ include file="js/index/button_reset.jsp" %>