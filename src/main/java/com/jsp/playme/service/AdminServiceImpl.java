package com.jsp.playme.service;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.playme.model.Admin;
import com.jsp.playme.model.Album;
import com.jsp.playme.model.Artist;
import com.jsp.playme.model.Track;
import com.jsp.playme.model.User;
import com.jsp.playme.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository aRepo;

	@Autowired
	private AlbumService albumService;

	@Autowired
	private TrackService trackService;

	@Autowired
	private ArtistService artistService;

	@Override
	public boolean checkAdminLogin(String mail, String password)
	{
		try
		{
			Admin a = aRepo.findByAdminemailAndAdminpassword(mail, password);
			if (a != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean storeData(Map<String, Object> album, Map<String, Object> track, Map<String, Object> artist, MultipartFile trackImage, MultipartFile audio, MultipartFile artistImage)
	{

		Integer albumid = (Integer) album.get("albumId");
		System.out.println(albumid);
		if (albumid != 0)
		{
			// Retrieve the existing album by ID
			Album album1 = albumService.findById(albumid);
			if (album1 == null)
			{
				System.out.println("Album not found");
				return false;
			}

			// Create the new track
			Track track1 = new Track();
			track1.setTrackname((String) track.get("trackName"));
			track1.setDuration((double) track.get("trackDuration"));
			try
			{
				track1.setAudio(audio.getBytes());
				track1.setTrackimage(trackImage.getBytes());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			track1.setType((String) track.get("categoryType"));
			track1.setLanguage((String) album.get("albumLanguage"));

			// Retrieve or create artist
			Artist artist1 = new Artist();
			artist1.setArtistname((String) artist.get("artistName"));
			try
			{
				artist1.setArtistimage(artistImage.getBytes());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

			// Retrieve or create artist
			Artist artist2 = artistService.findByName(artist1.getArtistname());
			if (artist2 == null)
			{
				artist2 = artistService.addArtist(artist1);
				if (artist2 == null)
				{
					System.out.println("Failed to create artist");
					return false;
				}
			}

			// Add artist to the track
			track1.setArtist(List.of(artist2));

			// Save the new track
			Track track2 = trackService.addTrack(track1);
			if (track2 == null)
			{
				System.out.println("Failed to create track");
				return false;
			}

			// Add the new track to the existing album
			List<Track> tracks = album1.getTrackid();
			if (tracks == null)
			{
				tracks = new ArrayList<>();
			}
			tracks.add(track2);
			album1.setTrackid(tracks);

			// Save the updated album
			Album updatedAlbum = albumService.addAlbum(album1); // Ensure this handles updates
			if (updatedAlbum == null)
			{
				System.out.println("Failed to update album");
				return false;
			}

			// Update the track with its associated album
			track2.setAlbumid(album1);
			Track trackUpdated = trackService.updateTrack(track2); // Ensure this method works
			if (trackUpdated == null)
			{
				System.out.println("Failed to update track");
				return false;
			}

			System.out.println("Track added to album successfully");
			return true;

		}
		else
		{

//    		Create album
			Album album1 = new Album();
			album1.setAlbumname((String) album.get("albumName"));
			album1.setReleasedate(Date.valueOf((String) album.get("releaseDate")));
			album1.setLanguage((String) album.get("albumLanguage"));

//    		Create track
			Track track1 = new Track();
			track1.setTrackname((String) track.get("trackName"));
			track1.setDuration((double) track.get("trackDuration"));
			try
			{
				track1.setAudio(audio.getBytes());
				track1.setTrackimage(trackImage.getBytes());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			track1.setType((String) track.get("categoryType"));
			track1.setLanguage((String) album.get("albumLanguage"));

//    		Create artist
			Artist artist1 = new Artist();
			artist1.setArtistname((String) artist.get("artistName"));
			try
			{
				artist1.setArtistimage(artistImage.getBytes());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

			Album album2 = albumService.addAlbum(album1);
			if (album2 != null)
			{
				System.out.println("Album created");
				Track track2 = trackService.addTrack(track1);

				if (track2 != null)
				{
					System.out.println("Track created");
					List<Track> tracks = new ArrayList<>();
					tracks.add(track2);

					album2.setTrackid(tracks);
					Album album3 = albumService.addAlbum(album2);

					artist1.setTrackid(tracks);
					Artist artist2 = artistService.addArtist(artist1);

					if (artist2 != null && album3 != null)
					{
						System.out.println("Album updated");
						System.out.println("Artist Created");
						track1.setAlbumid(album2);
						List<Artist> artists = new ArrayList<>();
						artists.add(artist1);
						track1.setArtist(artists);
						Track track3 = trackService.addTrack(track2);

						if (track3 != null)
						{
							System.out.println("Track Updated");
							return true;
						}
						else
						{
							return false;
						}
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			return false;
		}
	}

}
