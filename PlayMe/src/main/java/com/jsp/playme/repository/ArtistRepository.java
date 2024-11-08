package com.jsp.playme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.playme.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer>
{

	Artist findByArtistid(Integer artistid);

	Artist findByArtistname(String artistname);

}
