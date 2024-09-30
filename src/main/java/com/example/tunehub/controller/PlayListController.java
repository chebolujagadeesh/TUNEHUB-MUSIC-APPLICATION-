package com.example.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.tunehub.entities.PlayList;
import com.example.tunehub.entities.Song;
import com.example.tunehub.services.PlayListService;
import com.example.tunehub.services.SongService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class PlayListController {

	@Autowired
	PlayListService pservice;
	@Autowired
	SongService sserv;
	@GetMapping("/map-playlist")
	public String createSongsList(Model model)
	{
		List<Song> songList = sserv.getAllSongs();
		
		   model.addAttribute("songList", songList);
		  
		   return "createplaylist";
	}
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playList) {
		
	                   pservice.addPlayList(playList);
	                   System.out.println(playList);
	                 List <Song> songList= playList.getSong();
	                  for(Song song : songList)
	                  {
	                	   song.getPlayList().add(playList);
	                	   sserv.updateSong(song);
	                  }
		return "playlistsuccess";
	}
	@GetMapping("/viewplaylist")
	public String viewPlayList(Model model)
	{
		     List<PlayList>  plist = pservice.fetchPlayLists();
		     System.out.println(plist);
		    model.addAttribute("plist",plist);
		     return "viewplaylist";
	}
	
}
