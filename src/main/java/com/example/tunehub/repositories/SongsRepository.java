package com.example.tunehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunehub.entities.Song;


public interface SongsRepository extends JpaRepository<Song, Integer>{
             public Song findBySongName(String songName);
             
}
