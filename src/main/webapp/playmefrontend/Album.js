var allInp = document.querySelectorAll('input');

function storeAlbumData() {
    
    var album = {
        albumId:0,
        albumName: allInp[0].value,
        releaseDate: allInp[1].value,
        albumLanguage: allInp[2].value
    };

    if (album.albumName !== '' && album.releaseDate !== '' && album.albumLanguage !== '') {
        sessionStorage.setItem("album", JSON.stringify(album));
        window.location.href = "./Track.html";
    } else {
        alert("Please fill in all the required fields.");
    }
}