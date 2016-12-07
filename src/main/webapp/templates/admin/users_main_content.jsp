<%@ page import="com.excerloops.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<% List<User> users = (ArrayList<User>) session.getAttribute("users"); %>

<div id="wrapper">

    <!-- Map -->
    <div id="map">
        <img src="../resources/images/map2.png" style="width:100%;height:900px;"/>
    </div>

    <!-- Form on Top of Map -->
    <div id="over_map">

        <div id="users_form" class="container-fluid">

            <!-- Users Info -->
            <form>
                <legend>Users</legend>

                <table id="#users_table" class="table table-bordered">
                <thead>
                    <tr>
                        <th>Email</th>
                        <th>Name</th>
                        <th>Photo URL</th>
                        <th>UID</th>
                        <th>Role</th>
                        <th>Address</th>
                        <th>GPS</th>
                        <th># Loops</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>

                <!--Display information for each user -->
                <tbody>

                    <% for(int i=0; i<users.size(); i++) {
                        User u = users.get(i);
                    %>

                    <tr>
                        <!--Email-->
                        <td>
                            <div class="td_div" id="<%out.print(i);out.print(u.getEmail());%>email">
                                <% out.print(u.getEmail()); %>
                            </div>
                        </td>
                        <!--Name-->
                        <td>
                            <div id="<%out.print(i);out.print(u.getEmail());%>name" onclick="editOnClick(this);">
                                <% out.print(u.getName()); %>
                            </div>
                        </td>
                        <!--Photo Url-->
                        <td>
                            <div id="<%out.print(i);out.print(u.getEmail());%>photoUrl" onclick="editOnClick(this);">
                                <% out.print(u.getPhotoUrl()); %>
                            </div>
                        </td>
                        <!--Uid-->
                        <td>
                            <div id="<%out.print(i);out.print(u.getEmail());%>uid">
                                <% out.print(u.getUid()); %>
                            </div>
                        </td>
                        <!--Role-->
                        <td>
                            <div id="<%out.print(i);out.print(u.getEmail());%>role" onclick="editOnClick(this);">
                                <% out.print(u.getRole()); %>
                            </div>
                        </td>
                        <!--Address-->
                        <td>
                            <div id="<%out.print(i);out.print(u.getEmail());%>address" onclick="editOnClick(this);" style="float: left">
                                <% out.print(u.getHomeAddress()); %>
                            </div>
                            <a href="http://maps.google.com/?q=<% out.print(u.getHomeAddress()); %>" style="float:right;" target="_blank">
                                <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                            </a>
                        </td>
                        <!--Home GPS-->
                        <td>
                            <div id="<%out.print(i);out.print(u.getEmail());%>gps" onclick="editOnClick(this);" style="float: left">
                                <% out.print(u.getHomeGPS()); %>
                            </div>
                            <a href="http://maps.google.com/?q=<% out.print(u.getHomeGPS()); %>" style="float:right" target="_blank">
                                <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                            </a>
                        </td>

                        <!--Number of Loops Saved-->
                        <td>
                            <div id="<%out.print(i);out.print(u.getEmail());%>numLoops">
                                <% out.print(u.getSavedLoops().size()); %>
                            </div>
                        </td>

                        <!--Update (call servlet)-->
                        <td style="text-align: center">
                            <span class="glyphicon glyphicon-ok-circle" id="iconUpdate" name="<%out.print(i);out.print(u.getEmail());%>" aria-hidden="true" onclick="updateUser(this)"></span>
                        </td>

                        <!--Delete (call servlet)-->
                        <td style="text-align: center">
                            <span class="glyphicon glyphicon-remove-circle" id="iconDelete" aria-hidden="true"></span>
                        </td>

                    </tr>

                    <% } %>

                </tbody>
                </table>

            </form>

        </div>
    </div>
</div>
