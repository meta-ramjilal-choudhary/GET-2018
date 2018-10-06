//Validation functions-------------------Start----------------------------
//------------------------------------------------------------------------
function nameValidation(name, id){
    var regx = /^[A-Za-z]+$/;
    if(name.length > 2 && name.match(regx)){
        return{
            id : id,
            status : true
        };
    }
    return{
        id : id,
        status : false    
    };
}

function firstNameValidation(){
    var firstName = document.getElementById("first-name").value;
    return nameValidation(firstName, "First Name");
}

function lastNameValidation(){
    var lastName = document.getElementById("last-name").value;
    return nameValidation(lastName, "Last Name");
}

function emailValidation(){
    var email = document.getElementById("email").value;
    var regx = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(email.match(regx)){
        return {
            id : "Email",
            status : true
        };
    }
    return{
        id : "Email",
        status : false    
    };
}

function phoneValidation(){
    var phone = document.getElementById("phone").value;
    var regx = /^\d{10}$/;
    if(phone.match(regx)){
        return {
            id : "Phone",
            status : true
        };
    }
    return{
        id : "Phone",
        status : false    
    };
}

function addressValidation(){
    var address = document.getElementById("address").value;
    if(address.length > 10 && address.length < 100){
        return {
            id : "Address",
            status : true
        };
    }
    return {
        id : "Address",
        status : false
    };
}

function cityValidation(){
    var city = document.getElementById("city").value;
    var regx = /^[A-Za-z]+$/;
    if(city.match(regx)){
        return {
            id : "City",
            status : true
        };
    }
    return {
        id : "City",
        status : false
    };
}

function zipcodeValidation(){
    var zipcode = document.getElementById("zip-code");
    if(zipcode == null){
        return{
            id: zipcode,
            status: true
        };
    }
    zipcode = zipcode.value;
    var regx = /^\d{6}$/;
    if(zipcode.match(regx)){
        return {
            id : "zip-code",
            status : true
        };
    }
    return{
        id : "zip-code",
        status : false    
    };
}

function websiteValidation(){
    var website = document.getElementById("website");
    if(website == null){
        return{
            id : "website",
            status : true
        };
    }
    website = website.value;
    var regx = /^(http[s]?:\/\/){0,1}(www\.){0,1}[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,5}[\.]{0,1}/;
    if(website.match(regx)){
        return {
            id : "website",
            status : true
        };
    }
    return{
        id : "website",
        status : false    
    };
}
//Validation functions-----------------------end--------------------------
//------------------------------------------------------------------------


//DOM Creation Function-------------------Start---------------------------
//------------------------------------------------------------------------
function createZipCodeDOM(){
    var div = document.createElement("div");
    div.setAttribute("class", "input-container");
    div.setAttribute("id", "zipcode-block");
    
    var label = document.createElement("label");
    label.setAttribute("class", "label");
    var labelText = document.createTextNode("Zip Code");
    label.appendChild(labelText);
    
    var fontTag = document.createElement("i");
    fontTag.setAttribute("class", "fa fa-home icon");

    var inputTag = document.createElement("input");
    inputTag.setAttribute("class", "input-field");
    inputTag.setAttribute("type", "text");
    inputTag.setAttribute("placeholder", "Zip Code");
    inputTag.setAttribute("name", "zip-code");
    inputTag.setAttribute("id", "zip-code");

    div.appendChild(label);
    div.appendChild(fontTag);
    div.appendChild(inputTag);
    
    var element = document.getElementById("contact-form");
    var child = document.getElementById("send");
    element.insertBefore(div, child);
}

function createWebsiteDOM(){
    var div = document.createElement("div");
    div.setAttribute("class", "input-container");
    div.setAttribute("id", "website-block");
    
    var label = document.createElement("label");
    label.setAttribute("class", "label");
    var labelText = document.createTextNode("Website or domain name");
    label.appendChild(labelText);
    
    var fontTag = document.createElement("i");
    fontTag.setAttribute("class", "fa fa-globe-asia icon");

    var inputTag = document.createElement("input");
    inputTag.setAttribute("class", "input-field");
    inputTag.setAttribute("type", "text");
    inputTag.setAttribute("placeholder", "https://example.com");
    inputTag.setAttribute("name", "website");
    inputTag.setAttribute("id", "website");

    div.appendChild(label);
    div.appendChild(fontTag);
    div.appendChild(inputTag);
    
    var element = document.getElementById("contact-form");
    var child = document.getElementById("send");
    element.insertBefore(div, child);
}

function createHostingDOM(){
    var div = document.createElement("div");
    div.setAttribute("class", "input-container");
    div.setAttribute("id", "hosting-btn-block");
    
    var label = document.createElement("label");
    label.setAttribute("class", "label");
    var labelText = document.createTextNode("Do you have hosting?");
    label.appendChild(labelText);

    var buttonDiv = document.createElement("div");
    buttonDiv.setAttribute("class", "radio-button");
    buttonDiv.setAttribute("id", "hosting-option");


    var inputTag1 = document.createElement("input");
    inputTag1.setAttribute("type", "radio");
    inputTag1.setAttribute("name", "option");
    inputTag1.setAttribute("value", "yes");

    var inputTag2 = document.createElement("input");
    inputTag2.setAttribute("type", "radio");
    inputTag2.setAttribute("name", "option");
    inputTag2.setAttribute("value", "no");

    buttonDiv.appendChild(inputTag1);
    buttonDiv.appendChild(document.createTextNode("Yes"));
    buttonDiv.appendChild(document.createElement("br"));
    buttonDiv.appendChild(inputTag2);
    buttonDiv.appendChild(document.createTextNode("No"));

    div.appendChild(label);
    div.appendChild(buttonDiv);
    
    var element = document.getElementById("contact-form");
    var child = document.getElementById("send");
    element.insertBefore(div, child);
}

function createProjectDOM(){
    var div = document.createElement("div");
    div.setAttribute("class", "input-container");
    div.setAttribute("id", "project-desc-block");

    var label = document.createElement("label");
    label.setAttribute("class", "label");
    var labelText = document.createTextNode("Project Description");
    label.appendChild(labelText);

    var fontTag = document.createElement("i");
    fontTag.setAttribute("class", "fa fa-pen icon");

    var textAreaTag = document.createElement("textarea");
    textAreaTag.setAttribute("class", "input-field");
    textAreaTag.setAttribute("id", "project-desc");
    textAreaTag.setAttribute("name", "project-desc");
    var text = document.createTextNode("Project Description");
    textAreaTag.appendChild(text);

    div.appendChild(label);
    div.appendChild(fontTag);
    div.appendChild(textAreaTag);

    var element = document.getElementById("contact-form");
    var child = document.getElementById("send");
    element.insertBefore(div, child);
}
//DOM Creation Function-------------------end-----------------------------
//------------------------------------------------------------------------


//DOM Remove Function-------------------Start-----------------------------
//------------------------------------------------------------------------
function removeZipcodeDOM(){
    var element = document.getElementById("zipcode-block");
    if(element != null){
        element.parentNode.removeChild(element);
    }
}

function removeWebsiteDOM(){
    var element = document.getElementById("website-block");
    if(element != null){
        element.parentNode.removeChild(element);
    }
}

function removeHostingDOM(){
    var element = document.getElementById("hosting-btn-block");
    if(element != null){
        element.parentNode.removeChild(element);
    } 
}

function removeProjectDOM(){
    var element = document.getElementById("project-desc-block");
    if(element != null){
        element.parentNode.removeChild(element);
    }
}
//DOM Creation Function-------------------end-----------------------------
//------------------------------------------------------------------------


//Event Functions-----------------------start-----------------------------
//------------------------------------------------------------------------
function removeAll(){
    removeHostingDOM();
    removeZipcodeDOM();
    removeWebsiteDOM();
    removeProjectDOM();
}

function events(){
    var state = document.getElementById("states").value;
    if(state === "rajasthan"){
        removeAll();
        createWebsiteDOM();
        createProjectDOM();
    }
    else if(state === "haryana"){
        removeAll();
        createZipCodeDOM();
        createHostingDOM();
    }
    else if(state === "maharastra"){
        removeAll();
        createZipCodeDOM();
        createProjectDOM();
    }
}

function stateValidation(){
    var state = document.getElementById("states").value;
    if(state.length > 0){
        return {
            id : "State",
            status : true
        };
    }
    return {
        id : "State",
        status : false
    };
}
//Event Functions-----------------------end-------------------------------
//------------------------------------------------------------------------


//Profile Page DOM Manipulation----------start----------------------------
//------------------------------------------------------------------------
function profileForm(){
    var urlString = window.location;
    var url = new URL(urlString);
    var state = url.searchParams.get("states");
    document.getElementById("first-name").innerHTML = url.searchParams.get("first-name");
    document.getElementById("last-name").innerHTML = url.searchParams.get("last-name");
    document.getElementById("email").innerHTML = url.searchParams.get("email");
    document.getElementById("phone").innerHTML = url.searchParams.get("phone");
    document.getElementById("last-name").innerHTML = url.searchParams.get("last-name");
    document.getElementById("address").innerHTML = url.searchParams.get("address");
    document.getElementById("city").innerHTML = url.searchParams.get("city");
    document.getElementById("state").innerHTML = state;
    var zipcode = url.searchParams.get("zip-code");
    var website = url.searchParams.get("website");
    var hosting = url.searchParams.get("option");
    var proejctDesc = url.searchParams.get("project-desc");
    if(zipcode != null){
        var table = document.getElementById("form");
        var tr = document.createElement("tr");
        var th = document.createElement("th");
        var thText = document.createTextNode("Zip code");
        th.appendChild(thText);
        var td = document.createElement("td");
        td.setAttribute("id", "zip-code");
        tr.appendChild(th);
        tr.appendChild(td);
        table.appendChild(tr);
        document.getElementById("zip-code").innerHTML = zipcode;
    }
    if(website != null){
        var table = document.getElementById("form");
        var tr = document.createElement("tr");
        var th = document.createElement("th");
        var thText = document.createTextNode("Domain or Website name");
        th.appendChild(thText);
        var td = document.createElement("td");
        td.setAttribute("id", "website");
        tr.appendChild(th);
        tr.appendChild(td);
        table.appendChild(tr);
        document.getElementById("website").innerHTML = website;
    }
    if(hosting != null){
        var table = document.getElementById("form");
        var tr = document.createElement("tr");
        var th = document.createElement("th");
        var thText = document.createTextNode("Do you have hosting ?");
        th.appendChild(thText);
        var td = document.createElement("td");
        td.setAttribute("id", "option");
        tr.appendChild(th);
        tr.appendChild(td);
        table.appendChild(tr);
        document.getElementById("option").innerHTML = hosting;
    }
    if(proejctDesc != null){
        var table = document.getElementById("form");
        var tr = document.createElement("tr");
        var th = document.createElement("th");
        var thText = document.createTextNode("Project Description");
        th.appendChild(thText);
        var td = document.createElement("td");
        td.setAttribute("id", "project-desc");
        tr.appendChild(th);
        tr.appendChild(td);
        table.appendChild(tr);
        document.getElementById("project-desc").innerHTML = proejctDesc;
    }
}
//Profile Page DOM Manipulation----------start----------------------------
//------------------------------------------------------------------------


//Main Valid function--------------------start----------------------------
//------------------------------------------------------------------------
function valid(){
    var object = [];
    object.push(firstNameValidation());
    object.push(lastNameValidation());
    object.push(emailValidation());
    object.push(phoneValidation());
    object.push(addressValidation());
    object.push(cityValidation());
    object.push(stateValidation());
    object.push(zipcodeValidation());
    object.push(websiteValidation());
    var msg = "";
    for(var i=0; i<object.length; i++){
        if(!object[i].status){
            msg += object[i].id+": Not valid\n";
        }
    } 
    if(msg.length > 0){
        alert(msg);
        return false;
    }
    return true;
}
//Main Valid function--------------------end------------------------------
//------------------------------------------------------------------------