<!--SIGN_IN.JSP -->
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Head JSP Template -->
        <%@include file = "templates/parts/head.jsp" %>
        <!-- Custom Page CSS -->
        <style><%@ include file="resources/styles/authenticate.css" %></style>
        <link href="resources/styles/bootstrap-social.css" type="text/css" rel="stylesheet"/>
        <link href="resources/styles/bootstrap-social.css" type="text/css" rel="stylesheet"/>
    </head>

    <body onload="loadData()">
        <!-- Navbar JSP Template -->
        <%@ include file ="templates/parts/navbar.jsp" %>
        <!-- Main Page Content -->
        <%@ include file="templates/authenticate_main_content.jsp" %>
        <!-- Footer JSP Templates -->
        <%@ include file = "templates/parts/footer.jsp" %>
    </body>

</html>

<!-- CUSTOM PAGE SCRIPTS -->
<%@ include file="js/authenticate/_scripts.jsp" %>