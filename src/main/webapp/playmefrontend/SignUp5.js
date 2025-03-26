var myLayer = document.getElementById('next');
myLayer.class = "button:disabled";
myLayer.setAttribute("disabled", "disabled");
function checkedFunc(checkme1, checkme2) {
    var element1 = document.getElementById(checkme1);
    var element2 = document.getElementById(checkme2);
    if (element1.checked == true && element2.checked == true) {
        myLayer.class = "submit";
        myLayer.removeAttribute("disabled");
    }
    else {
        myLayer.class = "button:disabled";
        myLayer.setAttribute("disabled", "disabled");
    };
}

function saveUser(){
    var mail=sessionStorage.getItem("mail");
    var password=sessionStorage.getItem("pass");
    var username=sessionStorage.getItem("name1");
    var mobile=sessionStorage.getItem("mobile");
    var gender=sessionStorage.getItem("gender");
    if(mail!='' && password!='' && username!='' && mobile!='' && gender!='')
    {
        var user={
            'useremail': mail,
            'userpassword': password,
            'username': username,
            'usermobile': mobile,
            'usergender': gender
        }
        const response=fetch("http://localhost:8080/PlayMe/user",{
            method:"POST",
            headers:{
                "Content-Type":"application/json",
            },
            body:JSON.stringify(user),
        }).then(response => {
            if (!response.ok) {
                // Handle HTTP errors
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log(data); 
            if(data!==null)
            {
                sessionStorage.setItem("user",JSON.stringify(data));
                // myLayer.type="submit";
                // document.querySelector("form").action="./Home2.html";
                open(url="./Home2.html","_self");
            }
            else
            {
                document.getElementById("account").innerHTML="User Already Exists...!!!";
            }
        })
        .catch(error => {
            console.error("Error:", error);
        });
    }
}