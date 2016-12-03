<!-- ACCOUNT_SETTINGS.JSP -->
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Head JSP Template -->
        <%@include file = "templates/parts/head.jsp" %>
        <!-- Custom Page CSS -->
        <link rel="stylesheet" type="text/css" href="resources/styles/account.css">
    </head>

    <body onload="loadData()">
        <!-- Navbar JSP Template -->
        <%@ include file ="templates/parts/navbar.jsp" %>
        <!-- Main Page Content -->
        <%@ include file="templates/account_main_content.jsp" %>
        <!-- Footer JSP Templates -->
        <%@ include file = "templates/parts/footer.jsp" %>
    </body>

</html>

<!-- CUSTOM PAGE SCRIPTS -->
<%@ include file="js/account/load_form_data.jsp" %>
<%@ include file="js/account/listener_home_enable_change.jsp"%>
<%@ include file="js/account/listener_unit_enable_change.jsp"%>
<%@ include file="js/account/button_sign_out.jsp" %>