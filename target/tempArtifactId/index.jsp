<!-- INDEX.JSP -->
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Head JSP Template -->
        <%@ include file = "templates/parts/head.jsp" %>
        <!-- Custom Page CSS -->
        <style><%@ include file = "resources/styles/index.css"%></style>
    </head>

    <body onload="displayBackgroundMap()">
        <!-- Navbar JSP Template -->
        <%@ include file="templates/parts/navbar.jsp" %>
        <!-- Main Content -->
        <%@ include file="templates/main/index_main_content.jsp" %>
        <!-- Footer JSP Templates -->
        <%@ include file = "templates/parts/footer.jsp" %>
    </body>

</html>

<!-- CUSTOM PAGE SCRIPTS -->
<%@ include file="js/google_maps_background.jsp" %>
<%@ include file="js/find_me_button.jsp" %>
<%@ include file="js/generate_loop.jsp" %>