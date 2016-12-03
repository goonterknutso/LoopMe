<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                        <p id="textEmail"></p>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
                <!-- Name -->
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Name:</label>
                    <div class="col-sm-6">
                        <p id="textName"></p>
                    </div>
                </div>
                <!-- Photo URL -->
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" >Photo URL:</label>
                    <div class="col-sm-6">
                        <p id="textPhotoUrl"></p>
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



            <!-- Preferences -->
            <form>
                <legend>Preferences</legend>

                <!--Default Home Enabled-->
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Enable Default Home:</label>
                    <div class="col-sm-6">
                        <!--Default Home Checkbox-->
                        <label class="radio-inline" id="homeEnabledTrueLabel"><input name="homeEnable" type="radio" id="homeEnabledTrue">Yes</label>
                        <label class="radio-inline" id="homeEnabledFalseLabel"><input name="homeEnable" type="radio" id="homeEnabledFalse">No</label>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
                <!--Default Home-->
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="inputDefaultHome">Default Home:</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="inputDefaultHome" />
                    </div>
                </div>

                <!--Default Unit Enable-->
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Enable Default Unit:</label>
                    <div class="col-sm-6">
                        <!--Default Unit Checkbox-->
                        <label class="radio-inline" for="unitEnabledTrue" id="unitEnabledTrueLabel"><input name="unitEnable" type="radio" id="unitEnabledTrue">Yes</label>
                        <label class="radio-inline" for="unitEnabledFalse" id="unitEnabledFalseLabel"><input name="unitEnable" type="radio" id="unitEnabledFalse">No</label>
                    </div>
                </div>
                <!--Default Unit-->
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="selectUnit">Default Unit:</label>
                    <div class="col-sm-6">
                        <select class="form-control" id="selectUnit">
                            <option value="MI" id="selectMI">MI</option>
                            <option value="KM" id="selectKM">KM</option>
                        </select>
                    </div>
                </div>

                <!--Line Color-->
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="selectColor">Line Color:</label>
                    <div class="col-sm-6">
                        <select class="form-control" id="selectColor">
                            <option value="-65281" id="magenta">Magenta</option>
                            <option value="-16776961" id="blue">Blue</option>
                            <option value="-16711681" id="cyan">Cyan</option>
                            <option value="-16711936" id="green">Green</option>
                            <option value="-256" id="yellow">Yellow</option>
                            <option value="-65536" id="red">Red</option>
                            <option value="-16777216" id="black">Black</option>
                            <option value="-1" id="white">White</option>
                        </select>
                    </div>
                </div>

                <!--Mode of Transit-->
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="selectColor">Line Color:</label>
                    <div class="col-sm-6">
                        <select class="form-control" id="selectTransit">
                            <option value="RUN" id="selectRun">Walk/Run</option>
                            <option value="BIKE" id="selectBike">Bike</option>
                            <option value="DRIVE" id="selectDrive">Drive</option>
                        </select>
                    </div>
                </div>

                <!--Number of Markers-->
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="inputNumMarkers">Number of Markers:</label>
                    <div class="col-sm-6">
                        <input type="number" class="form-control" id="inputNumMarkers" />
                    </div>
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

                <!-- Admin Links -->
                <form id="adminForm" style="visibility: hidden;">
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


            </form>

        </div>
    </div>
</div>
