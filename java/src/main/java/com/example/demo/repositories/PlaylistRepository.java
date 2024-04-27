package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Playlist;

public class PlaylistRepository implements IPlaylistRepository {
    private final Map<Long, Playlist> playlistMap;
    private Long autoIncrement = 1L;

    public PlaylistRepository() {
        playlistMap = new HashMap<Long,Playlist>();
    }

    @Override
    public Playlist save(Playlist playlist) {
        // TODO Auto-generated method stub
        Playlist p = new Playlist(playlist.getName(), playlist.getSongs(), autoIncrement);
        playlistMap.put(autoIncrement, p);
        ++autoIncrement;
        return p;
    }

    @Override
    public Playlist update(Playlist playlist) {
        // TODO Auto-generated method stub
        Playlist p = playlistMap.put(playlist.getId(), playlist);
        return p;
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        return playlistMap.containsKey(id);
    }

    @Override
    public List<Playlist> findAll() {
        // TODO Auto-generated method stub
        return playlistMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(playlistMap.get(id));
    }
    @Override
    public Optional<Playlist> findByName(String name) {
        // TODO Auto-generated method stub
        List<Playlist> playlists = playlistMap.values().stream().filter(playlist -> playlist.getName().equals(name)).collect(Collectors.toList());   
        return playlists.size() > 0 ? Optional.ofNullable(playlists.get(0)) : null;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        playlistMap.remove(id);
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return playlistMap.size();
    }

}
