package com.example.tunehub.services;

import java.util.List;

import com.example.tunehub.entities.PlayList;

public interface PlayListService {

	public void addPlayList(PlayList playList);

	public List<PlayList> fetchPlayLists();

	

}
