var allInp = document.querySelectorAll('input');

var result = document.getElementById("result_cont");

var albumval;
function findAlbum() {
    var name1 = allInp[0].value;
    result.innerHTML = '';
    if (name1) {
        console.log(name1);
        result.innerHTML = '';
        fetchAlbum(name1);
    }
    else{
        console.log(name1);
        result.innerHTML = '';
    }
}

function displayAlbums(albums) {
    albums.forEach(album => {
        console.log(album.releasedate);
        const h2 = document.createElement('h2');
        h2.innerHTML = album.albumname;
        // h2.onclick = function () { h2.innerHTML = album.albumname + '<i class="fa-solid fa-check"></i>' }
        h2.onclick = function () { allInp[0].value = album.albumname;
            albumval=album;
            result.innerHTML='';
        }
        result.appendChild(h2);
    });

}

async function fetchAlbum(name1) {
    result.innerHTML = '';
    try {
        result.innerHTML = '';
        const response = await fetch(`http://localhost:8080/PlayMe/Model/searchAlbums?albumname=${name1}`);
        if (!response.ok) {
            result.innerHTML = '';
            throw new Error('Network response was not ok: ' + response.statusText + ' (status code: ' + response.status + ')');
        }
        else if(response.ok) {
            const albums = await response.json();
            console.log(albums); // Debugging line
            result.innerHTML = '';
            displayAlbums(albums);
            document.getElementById('result').innerHTML = '';
        }
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
        document.getElementById('result').innerHTML = 'No Albums Found'
        result.innerHTML = '';
    }
}

function storeAlbumData() {

    var dateString=albumval.releasedate;
    var date=new Date(dateString);
    var rDate=date.toLocaleDateString('en-CA');

    var album = {
        albumId:albumval.albumid,
        albumName: albumval.albumname,
        releaseDate: rDate,
        albumLanguage: albumval.language
    };

    if (album.albumId!=='' && album.albumName !== '' && album.releaseDate !== '' && album.albumLanguage !== '') {
        sessionStorage.setItem("album", JSON.stringify(album));
        window.location.href = "./Track.html";
    } else {
        alert("Please fill in all the required fields.");
    }
}