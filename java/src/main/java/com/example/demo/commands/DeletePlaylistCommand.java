package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.PlaylistService;

public class DeletePlaylistCommand implements ICommand {
    
    private final PlaylistService playlistService;

    public DeletePlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        String playlistName = tokens.get(1);
        Playlist playlist = playlistService.delete(playlistName);
        System.out.println("Playlist " + playlist.getName() + " is deleted!");
    }

}
