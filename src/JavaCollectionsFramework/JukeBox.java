package JavaCollectionsFramework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class JukeBox {

    ArrayList<Song> songs = new ArrayList<Song>();
    public static void main(String[] args) {
        new JukeBox().go();
    }

    class ArtistCompare implements Comparator<Song> {

        @Override
        public int compare(Song o1, Song o2) {
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }

    private void go() {
        getSongs();
        System.out.println(songs);
        Collections.sort(songs);
        System.out.println(songs);

        TreeSet<Song> songSet = new TreeSet<Song>(songs);


        System.out.println(songSet);
    }

    private void getSongs() {
        try {
            File file = new File("Songlist.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void addSong(String line) {
        String[] tokens = line.split("/");
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songs.add(nextSong);
    }
}
