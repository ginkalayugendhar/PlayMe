package com.jsp.playme.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer userid;
	@Column(nullable = false)
	private String username;
	@Column(unique = true, nullable = false)
	private String useremail;
	@Column(nullable = false)
	private String userpassword;
	@Column(unique = true, nullable = false)
	private String usermobile;
	@Column(nullable = false)
	private String usergender;
	@OneToMany
	private List<Artist> artistid;
	private List<String> language;
	@OneToMany
	private List<PlayList> playlistid;
	@OneToMany
	private List<Track> favorites;
}