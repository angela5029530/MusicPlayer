package idv.peiju;

import java.util.ArrayList;

public class PlayList {

    private int pointer = 0;
    private String name;

    public ArrayList<Song> songsInPlaylist = new ArrayList<Song>();

    public PlayList(String name){

        this.name = name;
    }

    // Add a song into a playlist

    public void addSong(String title, double duration){

        if(findSong(title) == null){

            songsInPlaylist.add(new Song(title, duration));

            System.out.println(title + " has been added into playlist.");

        }else{

            System.out.println(title + " is already in the playlist.");
        }
    }

    // Find a song if exist

    public Song findSong(String title){

        for(int i = 0; i < songsInPlaylist.size(); i++){

            boolean isExist = songsInPlaylist.get(i).getTitle().equals(title);

            if(isExist == true){

                return songsInPlaylist.get(i);
            }
        }

        return null;
    }

    // Play next song

    public Song nextSong(){

        if(pointer == songsInPlaylist.size() - 1){

            pointer = 0;

            Song song = songsInPlaylist.get(pointer);

            return song;

        }else{

            pointer ++;

            Song song = songsInPlaylist.get(pointer);

            return song;
        }
    }

    // Play previous song

    public Song previousSong(){

        if(pointer == 0){

            pointer = songsInPlaylist.size() - 1;

            Song song = songsInPlaylist.get(pointer);

            return song;

        }else{

            pointer--;

            Song song = songsInPlaylist.get(pointer);

            return song;
        }
    }

    // Replay song

    public Song replayCurrentSong(){

        Song song = songsInPlaylist.get(pointer);

        return song;
    }

    // Remove current song

    public void removeCurrentSong(){

        songsInPlaylist.remove(pointer);
    }
}
