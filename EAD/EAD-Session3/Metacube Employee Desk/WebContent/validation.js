function nameValidation(){
    var first_name = document.getElementById("first_name");
    var last_name = document.getElementById("last_name");
    var latters = /^[A-Za-z]+$/;
    if(first_name.value.length <= 2 || last_name.value.length <= 2){
        debugger;
        alert("Please insert a valid name");
        return false;
    }
    if(first_name.value.match(latters || last_name.value.match(latters))){
        return true;
    }
    else{
        alert("Please insert a valid name");
        return false;
    }
}

function emailValidation(){
    var email = document.getElementById("email");
    var validEmailPattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(email.value.match(validEmailPattern)){
        return true;
    }
    else{
        alert("Please insert a valid Email");
        return false;
    }
}

function validation(){
    if(!nameValidation() && !emailValidation()){
        return false;
    }
    return true;
}