package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.repositories.ISongRepository;

public class SongService {

    private final ISongRepository songRepository;

    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song create(String name, String artist, String album, String genre) {
            Song song = new Song(name, artist, album, genre);
            return songRepository.save(song);
    }

    public List<Song> listSongs() {
        return songRepository.findAll();
    }
}
