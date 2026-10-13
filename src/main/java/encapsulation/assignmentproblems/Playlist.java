
package encapsulation.assignmentproblems;

import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int capacity) {
        songs = new String[Math.max(0, capacity)];
        songCount = 0;
    }

    public void addSong(String song) {
        if (song != null && songCount < songs.length) {
            songs[songCount++] = song;
        } else {
            System.out.println("Cannot add song");
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Songs: " + Arrays.toString(copy));

        copy[0] = "Hacked";

        System.out.println("After modifying copy: "
                + Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}