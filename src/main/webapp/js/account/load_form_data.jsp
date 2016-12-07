<script>

<%@ page import="com.excerloops.entity.User" %>
<%@ page import="com.excerloops.entity.Preferences" %><%@ page import="com.excerloops.entity.SavedLoop"%><%@ page import="java.util.ArrayList"%>
<% User user = (User) session.getAttribute("user"); %>
<% ArrayList<SavedLoop> savedLoops = (ArrayList<SavedLoop>) session.getAttribute("savedLoops"); %>
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

    <%
    //Alert if preferences updated succesfully or not
    if(session.getAttribute("updatedPreferences") != null){
        if((Boolean)session.getAttribute("updatedPreferences")){
        %> alert("Preferences updated."); <%
        } else {
            %> alert("Error: Something went wrong while updating preferences. Please contact the administrator."); <%
        }
        session.removeAttribute("updatedPreferences");
    }
    //Alert if loop deleted successfully or not
    if(session.getAttribute("savedLoopDeleted") != null){
        if((Boolean)session.getAttribute("savedLoopDeleted")){
        %> alert("Loop deleted."); <%
        } else {
            %> alert("Error: Something went wrong while deleting saved loop. Please contact the administrator."); <%
        }
        session.removeAttribute("savedLoopDeleted");
    }
    %>


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


    //SAVED LOOPS TABLE
    //Hide if no saved loops
    <% if(savedLoops.size() == 0){ %>
        document.getElementById("savedLoops").style.display = "none";
    <% } %>

    //Otherwise build table
    var tbody = document.getElementById("savedLoopsTableBody");
    <% for(int i = 0; i<savedLoops.size(); i++){ %>
        var tr = document.createElement("TR");

        var nameTD = document.createElement("TD");
        var distKMTD = document.createElement("TD");
        var distMITD = document.createElement("TD");
        var addressTD = document.createElement("TD");
        var modeTD = document.createElement("TD");
        var viewTD = document.createElement("TD");
        var deleteTD = document.createElement("TD");

        nameTD.appendChild(document.createTextNode("<%= savedLoops.get(i).getName() %>"));
        distKMTD.appendChild(document.createTextNode("<%= savedLoops.get(i).getDistanceKM() %>"));
        distMITD.appendChild(document.createTextNode("<%= savedLoops.get(i).getDistanceMI() %>"));
        addressTD.appendChild(document.createTextNode("<%= savedLoops.get(i).getStartAddress() %>"));
        modeTD.appendChild(document.createTextNode("<%= savedLoops.get(i).getTransitMode() %>"));

        var viewIconButton = document.createElement("SPAN");
        viewIconButton.id = "<%= savedLoops.get(i).getId() %>";
        viewIconButton.setAttribute("name","viewIcons");
        viewIconButton.value = "<%= savedLoops.get(i).getName() %>";
        viewIconButton.classList.add("glyphicon");
        viewIconButton.classList.add("glyphicon-eye-open");
        viewIconButton.setAttribute("aria-hidden", "true");

        var deleteIconButton = document.createElement("SPAN");
        deleteIconButton.id = "<%= savedLoops.get(i).getId() %>";
        deleteIconButton.setAttribute("name","deleteIcons");
        deleteIconButton.value = "<%= savedLoops.get(i).getName() %>";
        deleteIconButton.classList.add("glyphicon");
        deleteIconButton.classList.add("glyphicon-remove-circle");
        deleteIconButton.setAttribute("aria-hidden", "true");

        viewTD.style.textAlign = "center";
        viewTD.appendChild(viewIconButton);
        deleteTD.style.textAlign = "center";
        deleteTD.appendChild(deleteIconButton);

        tr.appendChild(nameTD);
        tr.appendChild(distKMTD);
        tr.appendChild(distMITD);
        tr.appendChild(addressTD);
        tr.appendChild(modeTD);
        tr.appendChild(viewTD);
        tr.appendChild(deleteTD);

        tbody.appendChild(tr);
    <% } %>

    //Setup buttons when after created
    setupViewButtons();
    setupDeleteButtons();



    //Change Password and Delete Button
    //Hide if Google Email
    var user = firebase.auth().currentUser;
    if (user != null) {
        user.providerData.forEach(function (profile) {
            if(profile.providerId != "google.com"){
                document.getElementById("changePasswordForm").style.display = "block";
                document.getElementById("btnDeleteAccount").style.display = "inline-block";
            }
        });
    }


    //Admin Links

    <% if (user.getRole().equals("admin")) {
        %> document.getElementById("adminForm").style.display = "block"; <%
    } %>
}

</script>