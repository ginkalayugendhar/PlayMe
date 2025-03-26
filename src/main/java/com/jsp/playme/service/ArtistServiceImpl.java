package com.jsp.playme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.playme.model.Artist;
import com.jsp.playme.model.Track;
import com.jsp.playme.repository.ArtistRepository;

@Service
public class ArtistServiceImpl implements ArtistService
{
	@Autowired
	private ArtistRepository artistRepo;

	@Override
	public Artist addArtist(Artist artist)
	{
		try
		{
			Artist a = artistRepo.save(artist);
			if (a != null)
			{
				return a;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public List<Artist> getArtists()
	{
		return artistRepo.findAll();
	}

	@Override
	public List<Track> getArtistTracks(Integer artistid)
	{
		Artist artist = artistRepo.findByArtistid(artistid);
		if (artist != null)
		{
			return artist.getTrackid();
		}
		return null;
	}

	@Override
	public Artist findByName(String artistname)
	{
		return artistRepo.findByArtistname(artistname);
	}

}
