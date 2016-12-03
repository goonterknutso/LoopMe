<!-- GENEREATED_MAP.JSP -->
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Head JSP Template -->
        <%@ include file = "templates/parts/head.jsp" %>
        <!-- Custom Page CSS -->
        <style><%@ include file="resources/styles/generated_map.css" %></style>
    </head>

    <body onload="displayGeneratedMap()">
        <!-- Navbar JSP Template -->
        <%@ include file="templates/parts/navbar.jsp" %>
        <!-- Main Content -->
        <%@ include file="templates/generated_map_main_content.jsp" %>
        <!-- Footer JSP Templates -->
        <%@ include file = "templates/parts/footer.jsp" %>
    </body>

</html>

<!-- CUSTOM PAGE SCRIPTS -->
<%@ include file="js/generatedMap/generated_map_background.jsp" %>