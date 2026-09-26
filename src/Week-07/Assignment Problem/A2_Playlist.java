public class A2_Playlist {

    private final String[] songs;
    private int songCount;

    public A2_Playlist(int maximumSize) {
        songs = new String[maximumSize];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {

        A2_Playlist playlist = new A2_Playlist(10);

        playlist.addSong("Song A");
        playlist.addSong("Song B");

        String[] copy = playlist.getSongs();
        copy[0] = "Hacked";

        System.out.println("First song: " + playlist.getSongs()[0]);
        System.out.println("Song count: " + playlist.getSongCount());
    }
}