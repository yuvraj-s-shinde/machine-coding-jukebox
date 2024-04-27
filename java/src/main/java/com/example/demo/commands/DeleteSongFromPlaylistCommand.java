package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.PlaylistService;

public class DeleteSongFromPlaylistCommand implements ICommand {

    private final PlaylistService playlistService;
    
    public DeleteSongFromPlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        String playlistName = tokens.get(1);
        Long songId = Long.parseLong(tokens.get(2));
        Playlist playlist = playlistService.deleteSongFromPlaylist(playlistName, songId);
        System.out.println("Playlist " + playlist.getName() + " is revised with " + playlist.getSongs());    
    }

}
