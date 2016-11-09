<%@ page import="com.loopme.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>


<%
    List<User> users = (ArrayList<User>) session.getAttribute("users");
%>

<div id="wrapper">

    <!-- Map -->
    <div id="map" style="width:100%;height:900px;">
        <img src="../resources/images/map.png" />
    </div>

    <!-- Form on Top of Map -->
    <div id="over_map">

        <div id="saved_loops_form" class="container-fluid">

            <!-- Saved Loops Info -->
            <form>
                <legend>Saved Loops</legend>

                <!--Display information for each user -->
                <% for(User u : users) { %>
                    <

                <% } %>

            </form>

        </div>
    </div>
</div>