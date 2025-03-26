var allInp=document.querySelectorAll("input");

function loginCheck()
{
    var mail=allInp[0].value;
    var password=allInp[1].value;
    if(mail.length!=0 && password.length!=0)
    {
        const response=fetch("http://localhost:8080/PlayMe/checkEmailLogin",{
            method:"POST",
            headers:{
                'Content-Type': 'application/json'
            },
            body:JSON.stringify({'mail':mail,'password':password}),
        }).then(response=>
        {
            if(response.status===200)
            {
                open(URL="./Home2.html","_self");
                return response.json();
            }
            else{
                
                document.getElementById('result').innerHTML="Email or Password is incorrect"
            }
        }
        ).then(data=>{
            sessionStorage.setItem("user",JSON.stringify(data));
            // sessionStorage.setItem("userid",data.userid);
            // sessionStorage.setItem("username",data.username);
            // sessionStorage.setItem("usermail",data.useremail);
            // sessionStorage.setItem("usermobile",data.usermobile);
            // sessionStorage.setItem("usergender",data.usergender);
            // sessionStorage.setItem("artistid",data.artistid);
            // sessionStorage.setItem("language",data.language);
            // sessionStorage.setItem("playlistid",data.playlistid);
            // sessionStorage.setItem("favorites",data.favorites);
        })
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