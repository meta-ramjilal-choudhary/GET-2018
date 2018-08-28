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

function passwordValidation(){
    var pwd = document.getElementById("password");
    var confirm_pwd = document.getElementById("confirm_pwd");
    var validPwdPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
    if(pwd.value.match(validPwdPattern) && confirm_pwd.value.match(validPwdPattern)){
        if(pwd.value == confirm_pwd.value){
            return true;
        }
        else{
            alert("Password mismatch");
            return false;
        }
    }
    else{
        alert("Please insert a valid Password")
    }
}

function contactValidation(){
    var contact = document.getElementById("contact_number");
    var contactValidPattern = /^\d{10}$/;
    if(contact.value.match(contactValidPattern)){
        return true;
    }
    else{
        alert("Please insert a valid Contact number");
        return false;
    }
}

function validation(){
    if(nameValidation() == false){
        return false;
    }
    if(emailValidation() == false){
        return false;
    }
    if(passwordValidation() == false){
        return false;
    }
    if(contactValidation() == false){
        return false;
    }
    var form = document.getElementById("sign_up");
    form.submit();
}