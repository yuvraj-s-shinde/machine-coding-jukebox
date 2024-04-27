package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Song;

public class SongRepository implements ISongRepository {
    private final Map<Long,Song> songMap;
    private Long autoIncrement = 1L;

    public SongRepository() {
        songMap = new HashMap<Long,Song>();
    }

    @Override
    public Song save(Song song) {
        // TODO Auto-generated method stub
        Song s = new Song(song.getName(), song.getAlbum(), song.getArtist(), song.getGenre(), autoIncrement);
        songMap.put(autoIncrement, s);
        ++autoIncrement;
        return s;
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
       return songMap.containsKey(id);
    }

    @Override
    public List<Song> findAll() {
        // TODO Auto-generated method stub
        return songMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Song> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(songMap.get(id));
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        songMap.remove(id);
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return songMap.size();
    }

}
