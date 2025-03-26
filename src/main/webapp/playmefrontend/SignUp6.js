var allInp=document.querySelectorAll("input");

function storeTheData()
{
    var mobile=allInp[0].value;
    if(mobile.length!=0)
    {
        const response=fetch(`http://localhost:8080/PlayMe/checkMobile?mobile=${mobile}`,{
            method:"GET",
            headers:{
                'Content-Type': 'application/json'
            },
        }).then(response=>
        {
            if(response.status===200)
            {
                document.getElementById('result').innerHTML="Mobile is already exists...!!!"
            }
            else{
                sessionStorage.setItem("mobile",mobile);
                open(URL="./SignUp7.html","_self");
            }
        }
        )
    }
}
