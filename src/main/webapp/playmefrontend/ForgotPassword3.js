console.log(sessionStorage.getItem("mail"));

var allInp = document.querySelectorAll("input");

function storeTheData() {
    var pass = allInp[0].value;
    sessionStorage.setItem("pass", pass)
}


var myLayer = document.getElementById('next');
myLayer.class = "button:disabled";
myLayer.setAttribute("disabled", "disabled");
var inpVal;
function passwordLength() {
    inpVal = allInp[0].value;
    var valLen = inpVal.length;
    if (valLen == 0) {
        document.querySelector("#passwordCheck").innerHTML = "";
        myLayer.class = "button:disabled";
        myLayer.setAttribute("disabled", "disabled");
    }
    else if (valLen > 0 && valLen <= 7) {
        document.querySelector("#passwordCheck").innerHTML = validateInput(inpVal);
        document.querySelector("#passwordCheck").style.color = "orangered";
        myLayer.class = "button:disabled";
        myLayer.setAttribute("disabled", "disabled");
    }
    else if (validateInput(inpVal) !== "Valid input.") {
        document.querySelector("#passwordCheck").innerHTML = validateInput(inpVal);
        document.querySelector("#passwordCheck").style.color = "orangered";
        myLayer.class = "button:disabled";
        myLayer.setAttribute("disabled", "disabled");
    }
    else if (validateInput(inpVal) === "Valid input.") {
        document.querySelector("#passwordCheck").innerHTML = "";
        myLayer.class = "button:disabled";
        myLayer.setAttribute("disabled", "disabled");
    }
}

function samePassword() {
    var inpVal2 = allInp[1].value;
    var inpVal2len = inpVal2.length;
    console.log(inpVal2);
    if (inpVal2len == 0) {
        document.querySelector("#samePasswordCheck").innerHTML = "";
        myLayer.class = "button:disabled";
        myLayer.setAttribute("disabled", "disabled");
    }
    else if (inpVal2len > 0 && inpVal2len <= 7) {
        document.querySelector("#samePasswordCheck").innerHTML = "Password Missmatch";
        document.querySelector("#samePasswordCheck").style.color = "orangered";
        myLayer.class = "button:disabled";
        myLayer.setAttribute("disabled", "disabled");
    }
    else if (inpVal === inpVal2) {
        document.querySelector("#samePasswordCheck").innerHTML = "";
        myLayer.class = "submit";
        myLayer.removeAttribute("disabled");
    }
    else {
        myLayer.class = "button:disabled";
        myLayer.setAttribute("disabled", "disabled");
    };
}

function validateInput(value) {
    const lengthPattern = /^.{8}$/;
    const letterPattern = /[a-zA-Z]/;
    const specialOrNumberPattern = /[\d#?!&]/;

    if (!lengthPattern.test(value)) {
        return "Input must be exactly 8 characters long.";
    }
    if (!letterPattern.test(value)) {
        return "Input must contain at least one letter.";
    }
    if (!specialOrNumberPattern.test(value)) {
        return "Input must contain at least one number or special character (# ? ! &).";
    }
    return "Valid input.";
}