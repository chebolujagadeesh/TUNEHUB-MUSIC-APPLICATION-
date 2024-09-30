package com.example.tunehub.services;

import java.util.List;

import com.example.tunehub.entities.Song;

public interface SongService {

	public String addSong(Song song);
	public boolean songExists(String songName);
	public List<Song> getAllSongs();
	public void updateSong(Song song);


	
}
