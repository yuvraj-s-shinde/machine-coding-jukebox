package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.PlayerService;

public class NextSongCommand implements ICommand {

    private final PlayerService playerService;

    public NextSongCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        Song song = playerService.nextSong();
        System.out.println(song + " is playing!");
    }

}
