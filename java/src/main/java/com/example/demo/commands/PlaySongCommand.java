package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.PlayerService;

public class PlaySongCommand implements ICommand {

    private final PlayerService playerService;
    
    public PlaySongCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        Song song = playerService.playSong();
        if (playerService.isSongPlaying()) {
            System.out.println(song + " is playing!");
        } else {
            System.out.println(song + " is paused!");
        }

    }

}
