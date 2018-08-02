package JavaCollectionsFramework;

import org.jetbrains.annotations.NotNull;

public class Song implements Comparable<Song>{
    private String title;
    private String artist;
    private String rating;
    private String bpm;

    Song(String t, String a, String r, String b) {
        title = t;
        artist = a ;
        rating = r;
        bpm = b;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    @Override
    public String toString() {
        return title + ":" + artist;
    }

    @Override
    public int compareTo(@NotNull Song o) {
        return title.compareTo(o.getTitle());
    }
}
