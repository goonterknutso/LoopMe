<%@ page import="com.excerloops.entity.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<% User user = (User) session.getAttribute("user"); %>

<div id="wrapper">

    <!-- Map -->
    <div id="map" style="width:100%;height:900px;">
        <img src="../resources/images/map2.png" />
    </div>

    <!-- Form on Top of Map -->
    <div id="over_map">

        <div id="account_form" class="container-fluid">

            <!-- Account Info -->
            <form>
                <legend>Account Info</legend>
                <!-- Email -->
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Email:</label>
                    <div class="col-sm-6">
                        <p><% out.print(user.getEmail()); %></p>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
                <!-- Name -->
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Name:</label>
                    <div class="col-sm-6">
                        <p><% out.print(user.getName()); %></p>
                    </div>
                </div>
                <!-- Photo URL -->
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" >Photo URL:</label>
                    <div class="col-sm-6">
                        <p><% out.print(user.getPhotoUrl()); %></p>
                    </div>
                </div>




                <!-- TODO add link to their loops or just add them here -->


                <!-- Sign Out -->
                <div class="form-group">
                    <div class="col-lg-4 col-md-4 col-sm-4"></div>
                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <button id="btnSignOut" type="button" class="btn btn-default">Sign Out</button>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4"></div>
                </div>
            </form>


            <!-- Change Password -->
            <form>
                <legend>Change Password</legend>
                <!-- Change Password -->
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">New Password:</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="inputPassword" />
                    </div>
                </div>
                <!-- Confirm Password -->
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Confirm Password:</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="inputConfirmPassword" />
                    </div>
                </div>
                <!-- Update Password -->
                <div class="form-group">
                    <div class="col-lg-4 col-md-4 col-sm-4"></div>
                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <button id="btnUpdatePassword" type="button" class="btn btn-default">Update</button>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4"></div>
                </div>
            </form>


            <c:if test="${user.getRole() eq 'admin'}">
                <!-- Admin Links -->
                <form>
                    <legend>Admin Links</legend>
                    <div class="form-group">
                        <a class="col-sm-12" href="/users"> Users </a>
                    </div>
                    <div class="form-group">
                        <a class="col-sm-12" href="/savedLoops"> Saved Loops </a>
                    </div>
                    <div class="form-group">
                        <a class="col-sm-12" href="/preferences"> Preferences </a>
                    </div>

                </form>
            </c:if>

            </form>

        </div>
    </div>
</div>
