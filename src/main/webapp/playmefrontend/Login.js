var allInp=document.querySelectorAll("input");

async function loginCheck()
{
    var mobile=allInp[0].value;
    var password=allInp[1].value;
    if(mobile.length==10)
    {
        const response=await fetch(`http://localhost:8080/PlayMe/checkMobileLogin?mobile=${mobile}&password=${password}`,{
            method:"GET",
            headers:{
                'Content-Type': 'application/json'
            },
        })
        if(response.status===200)
        {
            const data=await response.json();
            sessionStorage.setItem("user",JSON.stringify(data));
            open(URL="./Home2.html","_self");
        }
        else{
            document.getElementById('result').innerHTML="Mobile or Password is incorrect"
        }
    }
    else
    {
        document.getElementById('result').innerHTML="Enter Correct Mobile Number"
    }
}

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