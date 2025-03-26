

async function fetchArtists() {
    try {
        const response = await fetch('http://localhost:8080/PlayMe/Model/artists');
        if (!response.ok) {
            throw new Error('Network response was not ok: ' + response.statusText + ' (status code: ' + response.status + ')');
        }
        const artists = await response.json();
        console.log(artists); // Debugging line
        displayTracks(artists);
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
        alert('Failed to fetch artists. See console for details.');
    }
}

function displayTracks(artists) {
    const tracksDiv = document.getElementById('artists');

    artists.forEach(artist => {
        
        const a1 = document.createElement('a');
        const b1=document.createElement('b');
        const img1=document.createElement('img');
        const h1=document.createElement('h1');
        const h6=document.createElement('h6');

        a1.className='song';
        a1.href='#';
        a1.onclick=function(){fetchArtistTracks(artist.artistid)};
        b1.className='playbutton';
        b1.innerHTML=`<i class="fa-solid fa-play"></i>`;

        img1.className='artistimg';
        img1.src=`data:image/jpeg;base64,${artist.artistimage}`;

        h1.innerHTML=artist.artistname;

        tracksDiv.appendChild(a1);
        a1.appendChild(b1);
        a1.appendChild(img1);
        a1.appendChild(h1);
        a1.appendChild(h6);
    });
}

async function fetchArtistTracks(artistid) {
    try {
        const response = await fetch(`http://localhost:8080/PlayMe/Model/artist/tracks?artistid=${artistid}`);
        if (!response.ok) {
            throw new Error('Network response was not ok: ' + response.statusText + ' (status code: ' + response.status + ')');
        }
        const tracks = await response.json();
        console.log(tracks); // Debugging line
        // displayTracks(artists);
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
        alert('Failed to fetch artists. See console for details.');
    }
}


window.onload = fetchArtists;