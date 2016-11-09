<%@ page import="com.loopme.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<% List<User> users = (ArrayList<User>) session.getAttribute("users"); %>

<div id="wrapper">

    <!-- Map -->
    <!--<div id="map">
        <img src="../resources/images/map.png" style="width:100%;height:900px;"/>
    </div>-->

    <!-- Form on Top of Map -->
    <div id="over_map">

        <div id="users_form" class="container-fluid">

            <!-- Users Info -->
            <form>
                <legend>Users</legend>

                <table id="#users_table" class="table table-striped">
                <thead>
                    <tr>
                        <th>Email</th>
                        <th>Name</th>
                        <th>Photo URL</th>
                        <th>UID</th>
                        <th>Role</th>
                        <th>Address</th>
                        <th>GPS</th>
                        <th>Saved Loops</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>

                <!--Display information for each user -->
                <tbody>

                    <% for(User u : users) { %>

                    <tr>
                        <td><input type="text" value="<% out.print(u.getEmail()); %>" /></td>
                        <td><input type="text" value="<% out.print(u.getName()); %>" /></td>
                        <td><input type="text" value="<% out.print(u.getPhotoUrl()); %>" /></td>
                        <td><input type="text" value="<% out.print(u.getUid()); %>" /></td>
                        <td><input type="text" value="<% out.print(u.getRole()); %>" /></td>
                        <td><input type="text" value="<% out.print(u.getHomeAddress()); %>" />
                            <a href="http://maps.google.com/?q=<% out.print(u.getHomeAddress()); %>">
                                <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                            </a>
                        </td>
                        <td><input type="text" value="<% out.print(u.getHomeGPS()); %>" />
                            <a href="http://maps.google.com/?q=<% out.print(u.getHomeGPS()); %>">
                                <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                            </a>
                        </td>
                        <td>0</td>
                        <td><span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span></td>
                        <td><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span></td>

                    </tr>

                    <% } %>

                </tbody>
                </table>

            </form>

        </div>
    </div>
</div>
