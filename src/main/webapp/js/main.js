function checkPass() {
    var pass = document.getElementById("pass");
    var re_pass = document.getElementById("re_pass");

    if (pass.value === re_pass.value) {
        re_pass.style.background = "green";
    }else{
         re_pass.style.background = "red";
    }
}

function showPass() {
    var pass = document.getElementById("pass");
    if (pass.type === "password") {
        pass.type = "text";
    } else {
        pass.type = "password";
    }
}
