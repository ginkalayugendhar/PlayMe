var allInp = document.querySelectorAll("input");

var myLayer = document.getElementById('next');
myLayer.class = "button:disabled";
myLayer.setAttribute("disabled", "disabled");
var inpVal;
function passwordLength() {
    inpVal = allInp[1].value;
    var valLen = inpVal.length;
    if (valLen == 0) {
        document.querySelector("#passwordCheck").innerHTML = "";
        myLayer.class = "button:disabled";
        myLayer.setAttribute("disabled", "disabled");
    }
    else if (valLen > 0 && valLen <= 7) {
        document.querySelector("#passwordCheck").innerHTML = validateInput(inpVal);
        myLayer.class = "button:disabled";
        myLayer.setAttribute("disabled", "disabled");
    }
    else if (validateInput(inpVal) !== "Valid input.") {
        document.querySelector("#passwordCheck").innerHTML = validateInput(inpVal);
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
    var inpVal2 = allInp[2].value;
    var inpVal2len = inpVal2.length;
    console.log(inpVal2);
    if (inpVal2len == 0) {
        document.querySelector("#samePasswordCheck").innerHTML = "";
        myLayer.class = "button:disabled";
        myLayer.setAttribute("disabled", "disabled");
    }
    else if (inpVal2len > 0 && inpVal2len <= 7) {
        document.querySelector("#samePasswordCheck").innerHTML = "Password Missmatch";
        myLayer.class = "button:disabled";
        myLayer.setAttribute("disabled", "disabled");
    }
    else if (inpVal === inpVal2) {
        document.querySelector("#samePasswordCheck").innerHTML = "";
        myLayer.type = "submit";
        myLayer.removeAttribute("disabled");
    }
    else {
        myLayer.class = "button:disabled";
        myLayer.setAttribute("disabled", "disabled");
    };
}

function validateInput(value) {
    const letterPattern = /[a-zA-Z]/;
    const specialOrNumberPattern = /[\d#?!&]/;

    if (value.length<=7) {
        return "Input must be more than 8 characters long.";
    }
    if(value.length>10)
    {
        return "Input must be less than 10 characters long.";
    }
    if (!letterPattern.test(value)) {
        return "Input must contain at least one letter.";
    }
    if (!specialOrNumberPattern.test(value)) {
        return "Input must contain at least one number or special character (# ? ! &).";
    }
    return "Valid input.";
}

function storeTheData() {
    var mail = allInp[0].value;
    var pass=allInp[1].value;
}

