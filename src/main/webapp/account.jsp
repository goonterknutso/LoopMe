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
        <%@ include file="templates/main/account_main_content.jsp" %>
        <!-- Footer JSP Templates -->
        <%@ include file = "templates/footer.jsp" %>
    </body>

</html>

<!-- CUSTOM PAGE SCRIPTS -->
<%@ include file="js/google_maps_background.jsp" %>
<%@ include file="js/sign_out.jsp" %>