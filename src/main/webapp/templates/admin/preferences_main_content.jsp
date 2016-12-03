<%@ page import="com.excerloops.entity.User" %>


<% User user = (User) session.getAttribute("user"); %>

<div id="wrapper">

    <!-- Map -->
    <div id="map" style="width:100%;height:900px;">
        <img src="../resources/images/map2.png" />
    </div>

    <!-- Form on Top of Map -->
    <div id="over_map">

        <div id="preferences_form" class="container-fluid">

            <!-- Preferences Info -->
            <form>
                <legend>Preferences</legend>
            </form>

        </div>
    </div>
</div>