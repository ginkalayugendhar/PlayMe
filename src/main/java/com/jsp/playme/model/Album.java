package com.jsp.playme.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Album
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer albumid;

	@OneToMany(mappedBy = "albumid", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Track> trackid;

	@Column(nullable = false)
	private String albumname;

	@Column(nullable = false)
	private Date releasedate;

	@Column(nullable = false)
	private String language;

	@Override
	public String toString()
	{
		return "Album{" + "albumid=" + albumid + ", albumname='" + albumname + '\'' + ", releasedate=" + releasedate + ", language='" + language + '\'' + '}';
	}
}
