package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.PlayerService;

public class LoadPlaylistCommand implements ICommand {

    private final PlayerService playerService;
    

    public LoadPlaylistCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        String playlistName = tokens.get(1);
        Playlist playlist = playerService.loadPlaylist(playlistName);
        System.out.println("Playlist " + playlist.getName() + " is loaded!");
    }

}
