package com.jsp.playme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.playme.model.Track;

public interface TrackRepository extends JpaRepository<Track, Integer>
{
	@EntityGraph(attributePaths =
	{ "albumid", "artist" })
	List<Track> findAll();
}
