<!--SIGN_IN.JSP -->
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Head JSP Template -->
        <%@include file = "templates/parts/head.jsp" %>
        <!-- Custom Page CSS -->
        <link href="resources/styles/authenticate.css" type="text/css" rel="stylesheet"/>
        <link href="resources/styles/bootstrap-social.css" type="text/css" rel="stylesheet"/>
        <link href="resources/styles/bootstrap-social.css" type="text/css" rel="stylesheet"/>
    </head>

    <body>
        <!-- Navbar JSP Template -->
        <%@ include file ="templates/parts/navbar.jsp" %>
        <!-- Main Page Content -->
        <%@ include file="templates/authenticate_main_content.jsp" %>
        <!-- Footer JSP Templates -->
        <%@ include file = "templates/parts/footer.jsp" %>
    </body>

</html>


<!-- CUSTOM PAGE SCRIPTS -->
<%@ include file="js/authenticate/button_create_account.jsp" %>
<%@ include file="js/authenticate/button_google_sign_in.jsp" %>
<%@ include file="js/authenticate/button_sign_in.jsp" %>
<%@ include file="js/authenticate/listener_auth_state_change.jsp" %>