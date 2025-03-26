var allInp = document.querySelectorAll('input');

function storeArtistData() {
    
    var artistName = allInp[0].value;
    var artistImage = allInp[1].files[0];

    var artist = {
        artistName: artistName,
    };

    if (artistName !== '') {
        sessionStorage.setItem("artist", JSON.stringify(artist));

        if (artistImage) {
            const readerartimg = new FileReader();
            readerartimg.onload = function(e3) {
                sessionStorage.setItem("artistImage", e3.target.result);
            };
            readerartimg.readAsDataURL(artistImage);
        }
        else{
            alert("File Not Found");
        }

        setTimeout(createAndSendDataArray, 2000);
    } else {
        alert("Please fill in all the required fields.");
    }
}
function createAndSendDataArray() {
    var album = sessionStorage.getItem("album");
    var track = sessionStorage.getItem("track");
    var artist = sessionStorage.getItem("artist");

    var trackImage = sessionStorage.getItem("trackImage");
    var audio = localStorage.getItem("audio");
    var artistImage = sessionStorage.getItem("artistImage");

    // console.log('Album:', album);
    // console.log('Track:', track);
    // console.log('Artist:', artist);
    // console.log('Track Image:', trackImage);
    // console.log('Audio:', audio);
    // console.log('Artist Image:', artistImage);

    var formData = new FormData();
    formData.append("album", new Blob([album], { type: "application/json" }));
    formData.append("track", new Blob([track], { type: "application/json" }));
    formData.append("artist", new Blob([artist], { type: "application/json" }));

    if (trackImage) {
        formData.append("trackImage", dataURItoBlob(trackImage), sessionStorage.getItem("trackimgname"));
    }

    if (audio) {
        formData.append("audio", dataURItoBlob(audio), sessionStorage.getItem("trackaudioname"));
    }

    if (artistImage) {
        formData.append("artistImage", dataURItoBlob(artistImage),allInp[1].files[0].name );
    }

    const response=fetch('http://localhost:8080/PlayMe/Model/data-transfer', {
        method: 'POST',
        body: formData
    })
    .then(response => {
        if(response.status===200)
        {
            setTimeout(clearLocalandSession,1000);
            return response.text();
        }
        else
        {
            console.error(error);
        }
    })
    .then(data => {
        console.log('Success:', data);
        // window.location.href = "./Artist.html";
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

// Helper function to convert data URI to Blob
function dataURItoBlob(dataURI) {
    if (typeof dataURI !== 'string') {
        console.error('Invalid data URI:', dataURI);
        return null;
    }

    var byteString = atob(dataURI.split(',')[1]);
    var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];
    var ab = new ArrayBuffer(byteString.length);
    var ia = new Uint8Array(ab);
    for (var i = 0; i < byteString.length; i++) {
        ia[i] = byteString.charCodeAt(i);
    }
    return new Blob([ab], { type: mimeString });
}

function clearLocalandSession(){
    sessionStorage.clear();
    localStorage.clear();
}