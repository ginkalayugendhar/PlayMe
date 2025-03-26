package com.jsp.playme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.playme.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer>
{

	List<Album> findByAlbumnameContaining(String albumname);

}
