package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.PlayerService;

public class PreviousSongCommand implements ICommand {

    private final PlayerService playerService;

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        Song song = playerService.prevSong();
        System.out.println(song + " is playing!");
    }

    public PreviousSongCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

}
