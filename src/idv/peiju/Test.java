package idv.peiju;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Testing
 */

public class Test {

    private static ArrayList<Album> album = new ArrayList<Album>();

    public static void main(String[] args) {

        // Create and add albums and add songs

        Album sky = new Album("Sky");

        sky.addSong("Star", 3.3);
        sky.addSong("Moon", 4.5);
        sky.addSong("Sun", 2.9);

        album.add(sky);

        Album rainBow = new Album("Rainbow");

        rainBow.addSong("Red", 5.4);
        rainBow.addSong("Orange", 2.1);
        rainBow.addSong("Yellow", 5.3);

        album.add(rainBow);

        // Create a playlist and add songs from albums

        PlayList playlist = new PlayList("My Playlist");

        Song song1 = album.get(0).findSong("Star");

        playlist.addSong(song1.getTitle(), song1.getDuration());

        Song song2 = album.get(1).findSong("Orange");

        playlist.addSong(song2.getTitle(), song2.getDuration());

        Song song3 = album.get(0).findSong("Moon");

        playlist.addSong(song3.getTitle(), song3.getDuration());

        // Can't add duplicate song

        Song song4 = album.get(0).findSong("Star");

        playlist.addSong(song4.getTitle(), song4.getDuration());

        play(playlist);


    }


    public static void printPlaylist(PlayList playlist) {

        System.out.println("Songs in the playlist: ");

        int size = playlist.songsInPlaylist.size();

        for (int i = 0; i < size; i++) {

            Song song = playlist.songsInPlaylist.get(i);

            System.out.println((i + 1) + ". " + song);
        }
    }

    public static void printMenu() {

        System.out.println("Available actions: \npress");

        System.out.println("0 - to quit\n" +

                "1 - to play next song\n" +

                "2 - to play previous song\n" +

                "3 - to replay the current song\n" +

                "4 - list songs in the playlist\n" +

                "5 - print available actions.\n" +

                "6 - delete current song from playlist");
    }

    public static void play(PlayList playlist) {

        boolean quit = false;

        if (playlist.songsInPlaylist.size() == 0) {

            System.out.println("No songs in the playlist.");

        } else {

            System.out.println("Now playing " + playlist.replayCurrentSong());

            printMenu();
        }

        while (!quit) {

            Scanner scanner = new Scanner(System.in);

            int action = scanner.nextInt();

            scanner.nextLine();

            switch (action) {

                case 0:

                    System.out.println("Playlist completed.");

                    quit = true;

                    break;

                case 1:

                    Song song = playlist.nextSong();

                    System.out.println("Now is playing " + song);

                    break;

                case 2:
                    Song song1 = playlist.previousSong();

                    System.out.println("Now is playing " + song1);

                    break;

                case 3:
                    Song song2 = playlist.replayCurrentSong();

                    System.out.println("Now is replaying " + song2);

                    break;

                case 4:

                    printPlaylist(playlist);

                    break;

                case 5:
                    printMenu();

                    break;

                case 6:

                    playlist.removeCurrentSong();
                    break;
            }

            printMenu();
        }
    }


}

