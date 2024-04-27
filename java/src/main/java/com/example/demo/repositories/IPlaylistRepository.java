package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Playlist;

public interface IPlaylistRepository {
    Playlist save(Playlist playlist);
    boolean existsById(Long id);
    List<Playlist> findAll();
    Optional<Playlist> findById(Long id);
    Playlist update(Playlist playlist);
    Optional<Playlist> findByName(String name);
    void deleteById(Long id);
    long count();   
}
