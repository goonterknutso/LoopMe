<!-- USERS.JSP -->
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Head JSP Template -->
        <%@ include file = "../templates/parts/head.jsp" %>
        <!-- Custom Page CSS -->
        <style><%@ include file = "../resources/styles/users.css"%></style>
    </head>

    <body style='background-image: url("../resources/images/map.png")';>
        <!-- Navbar JSP Template -->
        <%@ include file="../templates/parts/navbar.jsp" %>
        <!-- Main Content -->
        <%@ include file="../templates/admin/users_main_content.jsp" %>
        <!-- Footer JSP Templates -->
        <%@ include file = "../templates/parts/footer.jsp" %>
    </body>

</html>

<!-- CUSTOM JS -->
<%@ include file="../js/edit_text.jsp" %>
