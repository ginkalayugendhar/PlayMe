package com.jsp.playme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.playme.model.Track;
import com.jsp.playme.repository.TrackRepository;

@Service
public class TrackServiceImpl implements TrackService
{
	@Autowired
	private TrackRepository trackRepo;

	@Override
	public Track addTrack(Track track)
	{
		try
		{
			Track t = trackRepo.save(track);
			if (t != null)
			{
				return t;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Track> getTracks()
	{
		return trackRepo.findAll();
	}

	@Override
	public Track updateTrack(Track track)
	{
		// Check if the track exists by its ID
		if (trackRepo.existsById(track.getTrackid()))
		{
			return trackRepo.save(track); // Save updates if the track exists
		}
		else
		{
			throw new RuntimeException("Track not found with ID: " + track.getTrackid());
		}

	}
}
