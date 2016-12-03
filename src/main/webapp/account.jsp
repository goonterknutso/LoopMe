<!-- ACCOUNT_SETTINGS.JSP -->
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Head JSP Template -->
        <%@include file = "templates/parts/head.jsp" %>
        <!-- Custom Page CSS -->
        <link href="resources/styles/account.css" type="text/css" rel="stylesheet"/>
    </head>

    <body>
        <!-- Navbar JSP Template -->
        <%@ include file ="templates/parts/navbar.jsp" %>
        <!-- Main Page Content -->
        <%@ include file="templates/account_main_content.jsp" %>
        <!-- Footer JSP Templates -->
        <%@ include file = "templates/parts/footer.jsp" %>
    </body>

</html>

<!-- CUSTOM PAGE SCRIPTS -->
<%@ include file="js/account/sign_out.jsp" %>