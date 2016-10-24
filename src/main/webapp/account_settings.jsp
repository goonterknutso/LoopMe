<!-- ACCOUNT_SETTINGS.JSP -->
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Head JSP Template -->
        <%@include file = "templates/head.jsp" %>
        <!-- Custom Page CSS -->
        <style><%@include file = "resources/styles/account_settings.css"%></style>
    </head>


    <body>
        <!-- Navbar JSP Template -->
        <%@ include file ="templates/navbar.jsp" %>

        <!-- Main Page Content -->
        <div id="wrapper">

            <div id="sign_in_form" class="container-fluid">
                <!-- FORM -->
                <form>

                    <legend>Sign In</legend>

                    <!-- Email Input -->
                    <div class="form-group row">
                        <label for="input_email" class="col-sm-12 col-form-label">Email:</label>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <input type="email" class="form-control" id="input_email" placeholder="Enter your email address here!">
                        </div>
                    </div>

                    <!-- Password Input -->
                    <div class="form-group row">
                        <label for="input_password" class="col-sm-12 col-form-label">Password:</label>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <input type="password" class="form-control" id="input_password" placeholder="Enter a your password here!">
                        </div>
                    </div>

                    <!--Log In and Create Account Button -->
                    <div class="form-group row" id="div_buttons">
                        <div class="col-sm-4 col-sm-offset-4">
                            <div class="btn-group btn-group-lg" role="group" aria-label="...">
                                <button  type="submit" class="btn btn-primary btn-lg">Log In</button>
                            </div>
                            <div class="btn-group btn-group-lg" role="group" aria-label="..." >
                                <button id="button_create_account" type="submit" class="btn btn-secondary btn-lg">Create Account</button>
                            </div>
                        </div>
                    </div>

                    <hr />


                </form>

            </div>
        </div>
        <!-- Footer JSP Templates -->
        <%@ include file = "templates/footer.jsp" %>
    </body>


    <!-- BOOTSTRAP SCRIPTS -->
    <%@ include file="templates/bootstrap_scripts.jsp" %>

    </body>
</html>

