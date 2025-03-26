var divTag = document.querySelector("#addplaylistbut");
divTag.style.display="none";
var num1 = 0;
function addPlaylist() {
    num1++;
    if (num1 % 2 != 0) {
        divTag.style.display = "flex";
    }
    else {
        divTag.style.display = "none";
    }
}

var divTag2 = document.querySelector("#song");
divTag2.style.display="none";
var num2 = 0;
function maxmin() {
    num2++;
    if (num2 % 2 != 0) {
        divTag2.style.display = "flex";
    }
    else {
        divTag2.style.display = "none";
    }
}

var divTag3 = document.querySelector("#playlist_container");
divTag3.style.display="none";
var num3 = 0;
function playlist() {
    num3++;
    if (num3 % 2 != 0) {
        divTag3.style.display = "flex";
    }
    else {
        divTag3.style.display = "none";
    }
}

var divTag4 = document.querySelector("#profile_details");
divTag4.style.display="none";
var num4 = 0;
function profileDetails() {
    num4++;
    if (num4 % 2 != 0) {
        divTag4.style.display = "flex";
    }
    else {
        divTag4.style.display = "none";
    }
}

var user=JSON.parse(sessionStorage.getItem("user"));
document.getElementById("profile").innerHTML=user.username[0];
document.getElementById("profile_name").innerHTML=user.username;