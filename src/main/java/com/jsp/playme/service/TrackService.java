package com.jsp.playme.service;

import java.util.List;

import com.jsp.playme.model.Track;

public interface TrackService
{

	Track addTrack(Track track);

	List<Track> getTracks();

	Track updateTrack(Track track);

}
