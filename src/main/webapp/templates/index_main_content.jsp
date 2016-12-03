<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Main Page Content -->
<div id="wrapper">
    <!-- Map -->
    <div id="map" style="width:100%;height:900px;"></div>

    <!-- Form on Top of Map -->
    <div id="over_map">
        <div class="container-fluid">
            <!-- FORM -->
            <form>

                <legend>Generate Loop</legend>

                <!-- LOCATION INPUT -->
                <div class="form-group row">
                    <label for="inputLocation" class="col-sm-12 col-form-label">Location:</label>
                </div>
                <div class="form-group row">
                    <div class="col-sm-10 col-md-10 col-lg-10">
                        <input type="text" class="form-control" id="inputLocation" placeholder="Enter an address or GPS location here!">
                    </div>
                    <div class="col-sm-2 col-md-2 col-lg-2">
                        <a id="btnLocation" class="btn btn-secondary btn-default"><span class="glyphicon glyphicon-map-marker"></span> </a>
                    </div>
                </div>

                <!-- DISTANCE INPUT -->
                <div class="form-group row">
                    <label for="inputDistance" class="col-sm-12 col-md-12 col-lg-12">Distance:</label>
                </div>
                <div class="form-group row">
                    <div class="col-sm-8 col-md-8 col-lg-8">
                        <input type="text" class="form-control" id="inputDistance" placeholder="Enter a distance here!">
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-4">
                        <select class="form-control" id="inputDistanceUnit">
                            <option value="MI">MI</option>
                            <option value="KM">KM</option>
                        </select>
                    </div>
                </div>

            </form>


            <!--SUBMIT AND CLEAR BUTTONS -->
            <div class="group">
                <div class="col-lg-4 col-md-4 col-sm-4"></div>
                <div class="col-lg-4 col-md-4 col-sm-4">
                    <button id="btnGenerate" class="btn btn-success">Generate</button>
                    <button id="btnReset" type="reset" class="btn btn-danger">Reset</button>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4"></div>
            </div>

        </div>

    </div>
</div>