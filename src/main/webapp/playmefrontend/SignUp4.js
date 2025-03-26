console.log(sessionStorage.getItem("mail"));
console.log(sessionStorage.getItem("pass"));

var allInp=document.querySelectorAll("input");

function displayRadioValue() {
    var ele = document.getElementsByClassName('radio');
    for (i = 0; i < ele.length; i++) {
        if (ele[i].checked){
            return ele[i].value;
        }
    }
}

function storeTheData()
{
    var name1=allInp[0].value;
    sessionStorage.setItem("name1",name1);
    var mobile=allInp[1].value;
    sessionStorage.setItem("mobile",mobile);
    var gender=displayRadioValue();
    sessionStorage.setItem("gender",gender);
}
