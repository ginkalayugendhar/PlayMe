package com.jsp.playme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.playme.model.Album;
import com.jsp.playme.repository.AlbumRepository;

@Service
public class AlbumServiceImpl implements AlbumService
{
	@Autowired
	private AlbumRepository albumRepo;

	@Override
	public Album addAlbum(Album album)
	{
		try
		{
			Album a = albumRepo.save(album);
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
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<Album> getAlbums(String albumname)
	{
		List<Album> albums = albumRepo.findByAlbumnameContaining(albumname);
		System.out.println(albums);
		if (albums != null)
			return albums;
		return null;
	}

	@Override
	public Album findById(Integer albumid)
	{

		try
		{
			Optional<Album> a = albumRepo.findById(albumid);
			if (a != null)
			{
				return a.orElse(null);
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

}
