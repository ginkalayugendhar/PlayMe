var allInp=document.querySelectorAll("input");

function storeTheData()
{
    var mail=allInp[0].value;
    if(mail.length!=0)
    {
        const response=fetch(`http://localhost:8080/PlayMe/checkMail?mail=${mail}`,{
            method:"GET",
            headers:{
                'Content-Type': 'application/json'
            },
        }).then(response=>
        {
            if(response.status===200)
            {
                document.getElementById('result').innerHTML="Email is already exists...!!!"
            }
            else{
                sessionStorage.setItem("mail",mail);
                open(URL="./SignUp3.html","_self");
            }
        }
        )
    }
}
