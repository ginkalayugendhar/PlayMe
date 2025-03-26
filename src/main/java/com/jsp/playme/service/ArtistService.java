package com.jsp.playme.service;

import java.util.List;

import com.jsp.playme.model.Artist;
import com.jsp.playme.model.Track;

public interface ArtistService
{

	Artist addArtist(Artist artist);

	List<Artist> getArtists();

	List<Track> getArtistTracks(Integer artistid);

	Artist findByName(String artistname);

}
