package com.jsp.playme.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Artist
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer artistid;

	@Column(nullable = false)
	private String artistname;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "track_artist", joinColumns = @JoinColumn(name = "artistid"), inverseJoinColumns = @JoinColumn(name = "trackid"))
	@JsonBackReference
	private List<Track> trackid;

	@Column(nullable = false, columnDefinition = "LONGBLOB")
	@Lob
	private byte[] artistimage;

	@Override
	public String toString()
	{
		return "Artist{" + "artistid=" + artistid + ", artistname='" + artistname + '\'' + '}';
	}
}
