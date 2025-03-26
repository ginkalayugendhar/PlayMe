var allInp = document.querySelectorAll('input');

var trackDuration;
allInp[2].addEventListener('change', function(event) {
    const file = event.target.files[0];
    if (file) {
        const audio = new Audio(URL.createObjectURL(file));
        audio.addEventListener('loadedmetadata', function() {
            trackDuration=audio.duration;
        });
    }
});

function storeTrackData() {
    
    var trackName = allInp[0].value;
    var trackImage = allInp[1].files[0];
    var audio = allInp[2].files[0];
    var categoryType = allInp[3].value;

    var track = {
        trackName: trackName,
        categoryType: categoryType,
        trackDuration:trackDuration,
    };

    if (trackName !== '' && categoryType !== '') {
        sessionStorage.setItem("track", JSON.stringify(track));
        sessionStorage.setItem("trackimgname",allInp[1].files[0].name);
        sessionStorage.setItem("trackaudioname",allInp[2].files[0].name);

        if (trackImage) {
            const reader = new FileReader();
            reader.onload = function(e) {
                sessionStorage.setItem("trackImage", e.target.result);
            };
            reader.readAsDataURL(trackImage);
        }

        if (audio) {
            const readeraudio = new FileReader();
            readeraudio.onload = function(e1) {
                localStorage.setItem("audio", e1.target.result);
            };
            readeraudio.readAsDataURL(audio);
        }

        setTimeout(() => {
            window.location.href = "./Artist.html";
        }, 500);
    } else {
        alert("Please fill in all the required fields.");
    }
}

