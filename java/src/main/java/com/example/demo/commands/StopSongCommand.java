package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.PlayerService;

public class StopSongCommand implements ICommand {

    private final PlayerService playerService;

    public StopSongCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        Song song = playerService.stopSong();
        System.out.println(song + " is stopped!");
    }

}
