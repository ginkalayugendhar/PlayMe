package com.jsp.playme.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Track
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer trackid;

	@Column(nullable = false)
	private String trackname;

	@Column(nullable = false)
	private Double duration;

	private Integer likes;

	@Column(nullable = false)
	private String type;

	@Column(nullable = false)
	private String language;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "albumid")
	private Album albumid;

	@ManyToMany(mappedBy = "trackid")
	private List<Artist> artist;

	@Column(nullable = false, columnDefinition = "LONGBLOB")
	@Lob
	private byte[] trackimage;

	@Column(nullable = false, columnDefinition = "LONGBLOB")
	@Lob
	private byte[] audio;

	@Override
	public String toString()
	{
		return "Track{" + "trackid=" + trackid + ", trackname='" + trackname + '\'' + ", duration=" + duration + ", likes=" + likes + ", type='" + type + '\'' + ", language='" + language + '\'' + '}';
	}
}
