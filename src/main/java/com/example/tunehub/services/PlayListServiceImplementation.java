package com.example.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entities.PlayList;
import com.example.tunehub.repositories.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService {

	@Autowired
	PlayListRepository prepo;

	@Override
	public void addPlayList(PlayList playList) {
		prepo.save(playList);
		
	}

	@Override
	public List<PlayList> fetchPlayLists() {
		
		return prepo.findAll();
	}


}
