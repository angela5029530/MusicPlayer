package idv.peiju;

import java.util.ArrayList;

public class Album {

    private String name;
    private ArrayList<Song> songsInAlbum = new ArrayList<Song>();

    public Album(String name){
        this.name = name;
    }

    // Add a song into an album

    public boolean addSong(String title, double duration){

        if(findSong(title) == null){

            songsInAlbum.add(new Song(title, duration));

            System.out.println(title + " has been succefully added into album.");

            return true;

        }else{

            System.out.println(title + " is already in the album.");

            return false;
        }

    }

    // Find a song if exist

    public Song findSong(String title){

        for(int i = 0; i < songsInAlbum.size(); i++){

            boolean isSame = songsInAlbum.get(i).getTitle().equals(title);

            if(isSame == true){

                return songsInAlbum.get(i);
            }
        }

        return null;
    }
}
