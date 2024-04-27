package com.example.demo.services;

import java.util.ArrayDeque;
import java.util.Deque;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.repositories.IPlaylistRepository;

public class PlayerService {

    private final IPlaylistRepository playlistRepository;
    Playlist p;
    Deque<Song> currSongs = new ArrayDeque<>();
    boolean isPlaying = false;
    

    public PlayerService(IPlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public Playlist loadPlaylist(String playlistName) {
        p = playlistRepository.findByName(playlistName).get();
        currSongs.clear();
        currSongs.addAll(p.getSongs());
        return p;
    }

    public Song playSong() {
        isPlaying = !isPlaying;
        return currSongs.getFirst();
    }

    public boolean isSongPlaying() {
        return isPlaying;
    }

    public Song stopSong() {
        return currSongs.getFirst();
    }

    public Song nextSong() {
        Song s = currSongs.removeFirst();
        currSongs.addLast(s);
        return currSongs.getFirst();
    }

    public Song prevSong() {
        Song s = currSongs.removeLast();
        currSongs.addFirst(s);
        return currSongs.getFirst();
    }


}
