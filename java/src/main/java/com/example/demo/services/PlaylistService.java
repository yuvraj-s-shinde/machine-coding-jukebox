package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepository;

public class PlaylistService {

    private final ISongRepository songRepository;
    private final IPlaylistRepository playlistRepository;

    public PlaylistService(IPlaylistRepository playlistRepository, ISongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;

    }

    public Playlist create(String name, List<Long> songIds) {
        List<Song> songs = new ArrayList<>();
        for (Long songId: songIds) {
            songs.add(songRepository.findById(songId).get());
        }
        Playlist playlist = new Playlist(name, songs);
        return playlistRepository.save(playlist);
    }

    public Playlist addSongToPlaylist(String playlistName, Long songId) {
        Playlist playlist = playlistRepository.findByName(playlistName).get();
        playlist.addSong(songRepository.findById(songId).get());
        Playlist p = playlistRepository.update(playlist);
        return p;
    }

    public Playlist deleteSongFromPlaylist(String playlistName, Long songId) {
        Playlist playlist = playlistRepository.findByName(playlistName).get();
        playlist.removeSong(songRepository.findById(songId).get());
        Playlist p = playlistRepository.update(playlist);
        return p;
    }

    public Playlist delete(String playlistName) {
        Playlist playlist = playlistRepository.findByName(playlistName).get();
        playlistRepository.deleteById(playlist.getId());
        return playlist;
    }

}
