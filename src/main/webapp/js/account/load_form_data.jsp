<script>

<%@ page import="com.excerloops.entity.User" %>
<%@ page import="com.excerloops.entity.Preferences" %>
<% User user = (User) session.getAttribute("user"); %>
<% Preferences preferences = (Preferences) user.getPreferences(); %>

function loadData(){
    //Account Info
    var txtUid = document.getElementById("textUid");
    var txtEmail = document.getElementById("textEmail");
    var txtName = document.getElementById("textName");
    var txtPhotoUrl = document.getElementById("textPhotoUrl");
    txtUid.innerHTML = "<% out.print(user.getUid()); %>";
    txtEmail.innerHTML = "<% out.print(user.getEmail()); %>";
    txtName.innerHTML = "<% if(user.getName() == null){ out.print(""); }else{out.print(user.getName());} %>" ;
    txtPhotoUrl.innerHTML = "<% if(user.getPhotoUrl() == null){ out.print(""); }else{out.print(user.getPhotoUrl());} %>" ;

    if(txtName.innerHTML == "null"){
        txtName.innerHTML = "";
    }
    if(txtPhotoUrl.innerHTML == "undefined"){
        txtPhotoUrl.innerHTML = "";
    }


    //Preferences
    //Home Enabled
    <% if(preferences.getDefaultHomeEnabled()){ %>
        document.getElementById("homeEnabledTrue").checked = true;
        document.getElementById("homeEnabledTrueLabel").style.color = "green";
    document.getElementById("inputDefaultHome").disabled = false;
    document.getElementById("homeEnabledFalseLabel").style.color = "";
    <% } else { %>
        document.getElementById("homeEnabledFalse").checked = true;
        document.getElementById("inputDefaultHome").disabled = true;
        document.getElementById("homeEnabledFalseLabel").style.color = "red";
        document.getElementById("homeEnabledTrueLabel").style.color = "";
    <% } %>
    //Home
    document.getElementById("inputDefaultHome").value = "<% out.print(preferences.getDefaultHome()); %>";
    if(document.getElementById("inputDefaultHome").value == "undefined"){
        document.getElementById("inputDefaultHome").value = "";
    }

    //Unit Enabled
    <% if(preferences.getDefaultUnitEnabled()){ %>
        document.getElementById("unitEnabledTrue").checked = true;
        document.getElementById("unitEnabledTrueLabel").style.color = "green";
        document.getElementById("unitEnabledFalseLabel").style.color = "";
        document.getElementById("selectUnit").disabled = false;
    <% } else { %>
        document.getElementById("unitEnabledFalse").checked = true;
        document.getElementById("selectUnit").disabled = true;
        document.getElementById("unitEnabledFalseLabel").style.color = "red";
        document.getElementById("unitEnabledTrueLabel").style.color = "";
    <% }
   %>
    //Unit
    document.getElementById("selectUnit").value = "<% out.print(preferences.getDefaultUnit()); %>";

    //Line Color
    document.getElementById("selectColor").value = "<% out.print(preferences.getLineColor()); %>";
    <% 
    switch(preferences.getLineColor()){
        case -65281: %> document.getElementById("selectColor").style.color = "black"; document.getElementById("selectColor").style.backgroundColor = "magenta"; <% break;
        case -16776961: %> document.getElementById("selectColor").style.color = "white"; document.getElementById("selectColor").style.backgroundColor = "blue"; <% break;
        case -16711681: %> document.getElementById("selectColor").style.color = "black"; document.getElementById("selectColor").style.backgroundColor = "cyan"; <% break;
        case -16711936: %> document.getElementById("selectColor").style.color = "white"; document.getElementById("selectColor").style.backgroundColor = "green"; <% break;
        case -256: %> document.getElementById("selectColor").style.color = "black"; document.getElementById("selectColor").style.backgroundColor = "yellow"; <% break;
        case -65536: %> document.getElementById("selectColor").style.color = "white"; document.getElementById("selectColor").style.backgroundColor = "red"; <% break;
        case -16777216: %> document.getElementById("selectColor").style.color = "white"; document.getElementById("selectColor").style.backgroundColor = "black"; <% break;
        case -1: %> document.getElementById("selectColor").style.color = "black"; document.getElementById("selectColor").style.backgroundColor = "white"; <% break;
    } 
    %>

    //Transit Mode
    document.getElementById("selectTransit").value = "<% out.print(preferences.getTransitMode()); %>";

    //Number of Markers
    document.getElementById("inputNumMarkers").value = "<% out.print(preferences.getNumberOfMarkers()); %>";


    //Change Password
    //Hide if Google Email
    <%
    if(user.getEmail().contains("gmail")){
         %> document.getElementById("changePasswordForm").style.display = "none"; <%
    }
    %>

    //Admin Links

    <% if (user.getRole().equals("admin")) {
        %> document.getElementById("adminForm").style.display = "block"; <%
    } %>
}

</script>