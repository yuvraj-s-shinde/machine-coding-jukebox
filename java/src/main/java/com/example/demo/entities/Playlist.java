package com.example.demo.entities;

import java.util.List;

public class Playlist {
    private Long id;
    private String name;
    private List<Song> songs;
    
    public Playlist(String name, List<Song> songs, Long id) {
        this.id = id;
        this.name = name;
        this.songs = songs;
    }

    public Playlist(String name, List<Song> songs) {
        this(name, songs, null);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }   

    public List<Song> getSongs() {
        return songs;
    }   

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Playlist other = (Playlist) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Playlist [id=" + id + "]";
    }

}
