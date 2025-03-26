function passVisible()
{
    document.querySelector("#passInp").type="text";
    document.querySelector("i").className="fa-solid fa-eye-slash";
}
function passInvisible()
{
    document.querySelector("#passInp").type="password";
    document.querySelector("i").className="fa-solid fa-eye";
}

var allInp=document.querySelectorAll("input");

function loginCheck()
{
    var mail=allInp[0].value;
    var password=allInp[1].value;
    if(mail.length!=0 && password.length!=0)
    {
        const response=fetch(`http://localhost:8080/PlayMe/admin/login?mail=${mail}&password=${password}`,{
            method:"GET",
            headers:{
                'Content-Type': 'application/json'
            },
        }).then(response=>
        {
            if(response.status===200)
            {
                open(URL="./SearchAlbum.html","_self");
            }
            else{
                
                document.getElementById('result').innerHTML="Email or Password is incorrect"
            }
        }
        )
    }
}