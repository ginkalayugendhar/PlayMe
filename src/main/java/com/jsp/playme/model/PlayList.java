package com.jsp.playme.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class PlayList
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer playlistid;
	@Column(nullable = false)
	private String playlistname;
	@ManyToOne
	private User userid;
	@Column(nullable = false)
	@OneToMany
	private List<Track> trackid;
}