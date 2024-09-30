package com.example.tunehub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entities.Song;
import com.example.tunehub.repositories.SongsRepository;

@Service
public class SongServiceImplementation implements SongService{
	@Autowired
	SongsRepository srepo;
	
	public String addSong(Song song) {
		
		 srepo.save(song);
		return "added succcessfully";
	}

	
	public boolean songExists(String songName) {
		
		if(srepo.findBySongName(songName)==null)
		{
			return false;

		}
		else
		{
			return true;
		}
		
	}


	@Override
	public List<Song> getAllSongs() {
		
		return srepo.findAll();
	}


	@Override
	public void updateSong(Song song) {
		srepo.save(song);
		
	}


	   

}
