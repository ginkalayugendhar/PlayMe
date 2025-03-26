package com.jsp.playme.service;

import java.util.List;

import com.jsp.playme.model.Album;

public interface AlbumService
{

	Album addAlbum(Album album);

	List<Album> getAlbums(String albumname);

	Album findById(Integer albumid);

}
