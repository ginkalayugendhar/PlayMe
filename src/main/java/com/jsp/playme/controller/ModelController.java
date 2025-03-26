package com.jsp.playme.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.playme.model.Album;
import com.jsp.playme.model.Artist;
import com.jsp.playme.model.Track;
import com.jsp.playme.repository.TrackRepository;
import com.jsp.playme.service.AdminService;
import com.jsp.playme.service.AlbumService;
import com.jsp.playme.service.ArtistService;
import com.jsp.playme.service.TrackService;

@Controller
@RequestMapping("/PlayMe/Model")
@CrossOrigin(origins = "http://127.0.0.1:5501")
public class ModelController
{
//	private static final Logger logger = Logger.getLogger(ModelController.class.getName());

	@Autowired
	private AlbumService albumService;

	@Autowired
	private TrackService trackService;

	@Autowired
	private ArtistService artistService;

	@Autowired
	private AdminService adminService;

//	@Transactional
	@PostMapping(value = "/data-transfer", consumes =
	{ "multipart/form-data" })
	public ResponseEntity<String> handleUpload(@RequestPart Map<String, Object> album, @RequestPart Map<String, Object> track, @RequestPart Map<String, Object> artist, @RequestPart MultipartFile trackImage, @RequestPart MultipartFile audio, @RequestPart MultipartFile artistImage) throws IOException
	{
		System.out.println(album);
		System.out.println(track);
		System.out.println(artist);
		System.out.println(trackImage);
		System.out.println(audio);
		System.out.println(artistImage);

		if (adminService.storeData(album, track, artist, trackImage, audio, artistImage))
		{
			return new ResponseEntity<String>("Data inserted successfully", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Data received successfully but not inserted", HttpStatus.OK);

	}

	@GetMapping(value = "/tracks", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Track>> getAllTracks()
	{

		List<Track> tracks = trackService.getTracks();
		if (!tracks.isEmpty())
		{
			return ResponseEntity.ok(tracks);
		}
		else
		{
			return new ResponseEntity<List<Track>>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/artists", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Artist>> getAllArtists()
	{

		List<Artist> artists = artistService.getArtists();
		if (!artists.isEmpty())
		{
			return ResponseEntity.ok(artists);
		}
		else
		{
			return new ResponseEntity<List<Artist>>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/artist/tracks", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Track>> getAllArtistTracks(@RequestParam Integer artistid)
	{

		List<Track> tracks = artistService.getArtistTracks(artistid);
		if (!tracks.isEmpty())
		{
			return ResponseEntity.ok(tracks);
		}
		else
		{
			return new ResponseEntity<List<Track>>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/searchAlbums", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Album>> getSearchedAlbums(@RequestParam String albumname)
	{
		System.out.println(albumname);

		List<Album> albums = albumService.getAlbums(albumname);
		System.out.println(albums);
		if (!albums.isEmpty())
		{
			return ResponseEntity.ok(albums);
		}
		else
		{
			return new ResponseEntity<List<Album>>(HttpStatus.NOT_FOUND);
		}
	}
}
