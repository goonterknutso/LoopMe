<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Generated Map Main Content -->
<div id="wrapper">
    <!-- Map -->
    <div id="map" style="width:100%;height:900px;"></div>

    <!-- Form on Top of Map -->
    <div id="over_map">
        <div class="container-fluid">
            <!--FAB BUTTONS-->
            <div class="group" id="fabButtons">
            <div class="group row">
                <div class="col-lg-3 col-md-6 col-sm-12">
                    <input type="image" src="resources/images/info_icon.png" class="iconButton" id="btnInfo"/>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12">
                    <input type="image" src="resources/images/map_icon.png" class="iconButton" id="btnMap"/>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12">
                    <input type="image" src="resources/images/save_icon.png" class="iconButton" id="btnSave"/>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12">
                    <input type="image" src="resources/images/new_icon.png" class="iconButton" id="btnNew"/>
                </div>
            </div>


            <!-- INFO -->
            <div id="divInfo" style="display: none">
                <legend>Loop Info</legend>

                <!-- START ADDRESS -->
                <div class="group row">
                    <label class="col-sm-6">Start Address:</label>
                    <p class="col-sm-6"><%= request.getAttribute("address") %></p>
                </div>

                <!-- START GPS -->
                <div class="group row">
                    <label class="col-sm-6">Start GPS:</label>
                    <p class="col-sm-6">(<%= request.getAttribute("startLatLng").toString() %>)</p>
                </div>

                <!-- INPUT DISTANCE -->
                <div class="group row">
                    <label class="col-sm-6">Input Distance:</label>
                    <p class="col-sm-6"><%= request.getAttribute("distance") %></p>
                </div>

                <!-- INPUT UNIT -->
                <div class="group row">
                    <label class="col-sm-6">Input Unit:</label>
                    <p class="col-sm-6"><%= request.getAttribute("unit") %></p>
                </div>

                <!-- DISTANCE(KM) -->
                <div class="group row">
                    <label class="col-sm-6">Distance (KM):</label>
                    <p class="col-sm-6"><%= request.getAttribute("distanceGeneratedKM") %></p>
                </div>

                <!-- DISTANCE (MI) -->
                <div class="group row">
                    <label class="col-sm-6">Distance (MI):</label>
                    <p class="col-sm-6"><%= request.getAttribute("distanceGeneratedMI") %></p>
                </div>

                <!-- MARKERS -->
                <div class="group row">
                    <label class="col-sm-6">Markers:</label>
                    <p class="col-sm-6"><%= request.getAttribute("numMarkers") %></p>
                </div>



            </div>


        </div>

    </div>
</div>