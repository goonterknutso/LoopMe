<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="wrapper">

    <!-- Map -->
    <div id="map" style="width:100%;height:900px;"></div>

    <!-- Form on Top of Map -->
    <div id="over_map">

        <div id="sign_in_form" class="container-fluid">
            <!-- FORM -->
            <form>

                <legend>Sign In</legend>

                <!-- Email Input -->
                <div class="form-group row">
                    <label for="inputEmail" class="col-sm-12 col-form-label">Email:</label>
                </div>
                <div class="form-group row">
                    <div class="col-sm-12">
                        <input type="email" class="form-control" id="inputEmail" placeholder="Enter email here!">
                    </div>
                </div>

                <!-- Password Input -->
                <div class="form-group row">
                    <label for="inputPassword" class="col-sm-12 col-form-label">Password:</label>
                </div>
                <div class="form-group row">
                    <div class="col-sm-12">
                        <input type="password" class="form-control" id="inputPassword" placeholder="Enter password here!">
                    </div>
                </div>

                <!-- Sign In/ Sign Up -->
                <div class="form-group">
                    <div class="col-lg-4 col-md-4 col-sm-4"></div>
                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <button id="btnSignIn" type="button" class="btn btn-default">Sign In</button>
                        <button id="btnSignUp" type="button" class="btn btn-default">Sign Up</button>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4"></div>
                </div>

                <!-- Form Divide Line -->
                <div class="form-group row">
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <hr />
                    </div>
                </div>

                <!-- Google Sign In Button -->
                <div class="form-group row">
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <a class="btn btn-block btn-social btn-google" id="btnGoogle">
                            <span class="fa fa-google">
                                <img src="resources/images/google_icon.png" style="width: 20px; height: 20px"/>
                            </span>
                            Sign in with Google
                        </a>
                    </div>
                </div>

            </form>

        </div>
    </div>
</div>
