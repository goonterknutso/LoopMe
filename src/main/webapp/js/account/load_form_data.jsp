<script>

<%@ page import="com.excerloops.entity.User" %>
<%@ page import="com.excerloops.entity.Preferences" %>
<% User user = (User) session.getAttribute("user"); %>
<% Preferences preferences = (Preferences) user.getPreferences(); %>

function loadData(){
    //Account Info
    var txtEmail = document.getElementById("textEmail");
    var txtName = document.getElementById("textName");
    var txtPhotoUrl = document.getElementById("textPhotoUrl");
    txtEmail.innerHTML = "<% out.print(user.getEmail()); %>";
    txtName.innerHTML = "<% if(user.getName() == null){ out.print(""); }else{out.print(user.getName());} %>" ;
    txtPhotoUrl.innerHTML = "<% if(user.getPhotoUrl() == null){ out.print(""); }else{out.print(user.getPhotoUrl());} %>" ;


    //Preferences
    //Home Enabled
    <% if(preferences.getDefaultHomeEnabled()){ %>
        document.getElementById("homeEnabledTrue").checked = true;
        document.getElementById("homeEnabledTrueLabel").style.color = "green";
    <% } else { %>
        document.getElementById("homeEnabledFalse").checked = true;
        document.getElementById("inputDefaultHome").disabled = true;
        document.getElementById("homeEnabledFalseLabel").style.color = "red";
    <% } %>
    //Home
    document.getElementById("inputDefaultHome").setAttribute("text", "<% out.print(preferences.getDefaultHome()); %>");

    //Unit Enabled
    <% if(preferences.getDefaultUnitEnabled()){ %>
        document.getElementById("unitEnabledTrue").checked = true;
        document.getElementById("unitEnabledTrueLabel").style.color = "green";
    <% } else { %>
        document.getElementById("unitEnabledFalse").checked = true;
        document.getElementById("selectUnit").disabled = true;
        document.getElementById("unitEnabledFalseLabel").style.color = "red";
    <% }
   %>
    //Unit
    document.getElementById("selectUnit").value = "<% out.print(preferences.getDefaultUnit()); %>";

    //Line Color
    document.getElementById("selectColor").value = "<% out.print(preferences.getLineColor()); %>";

    //Transit Mode
    document.getElementById("selectTransit").value = "<% out.print(preferences.getTransitMode()); %>";

    //Number of Markers
    document.getElementById("inputNumMarkers").value = "<% out.print(preferences.getNumberOfMarkers()); %>";

    //Admin Links
    <%
    if (user.getRole().equals("admin")) {
        %> document.getElementById("adminLinks").style.visibility = "visible"; <%
    }
    %>
}

</script>