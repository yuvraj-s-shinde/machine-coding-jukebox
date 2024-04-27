package com.example.demo.commands;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.PlaylistService;

public class CreatePlaylistCommand implements ICommand{

    private final PlaylistService playlistService; 

    public CreatePlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);
        List<Long> songIds = new ArrayList<>();
        for (int i = 2; i < tokens.size(); i++) {
            songIds.add(Long.parseLong(tokens.get(i)));
        }
        Playlist playlist = playlistService.create(name, songIds);
        System.out.println(playlist);
    }
    
}
