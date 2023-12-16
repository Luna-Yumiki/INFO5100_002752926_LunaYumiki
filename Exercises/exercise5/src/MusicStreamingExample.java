
//Write a console program to demonstrate the use (in real-life like example) for at least three design pattern implementation in Java
import java.util.ArrayList;
import java.util.List;

interface User {
    void update(String songName);
}

class MusicService {
    private static MusicService instance;
    private List<User> users;
    private List<String> songs;

    private MusicService() {
        users = new ArrayList<>();
        songs = new ArrayList<>();
    }

    public static MusicService getInstance() {
        if (instance == null) {
            instance = new MusicService();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void notifyUsers(String songName) {
        for (User user : users) {
            user.update(songName);
        }
    }

    public void addSong(String songName) {
        songs.add(songName);
        notifyUsers(songName);
    }
}

interface Song {
    void play();
}

class PopSong implements Song {
    private String name;

    public PopSong(String name) {
        this.name = name;
    }

    public void play() {
        System.out.println("Playing Pop Song: " + name);
    }
}

class RockSong implements Song {
    private String name;

    public RockSong(String name) {
        this.name = name;
    }

    public void play() {
        System.out.println("Playing Rock Song: " + name);
    }
}

class UserPlaylist {
    private static UserPlaylist instance;
    private List<Song> playlist;

    private UserPlaylist() {
        playlist = new ArrayList<>();
    }

    public static UserPlaylist getInstance() {
        if (instance == null) {
            instance = new UserPlaylist();
        }
        return instance;
    }

    public void addSongToPlaylist(Song song) {
        playlist.add(song);
    }

    public void playPlaylist() {
        for (Song song : playlist) {
            song.play();
        }
    }
}

public class MusicStreamingExample {
    public static void main(String[] args) {
        MusicService musicService = MusicService.getInstance();
        UserPlaylist userPlaylist = UserPlaylist.getInstance();

        User user1 = songName -> System.out.println("User 1: New song released - " + songName);
        User user2 = songName -> System.out.println("User 2: New song released - " + songName);

        musicService.addUser(user1);
        musicService.addUser(user2);

        // Simulate new song releases and user playlist
        Song popSong = new PopSong("Pop Song: Dancing in the Moonlight");
        Song rockSong = new RockSong("Rock Song: Hotel California");

        musicService.addSong("Pop Song: Dancing in the Moonlight");
        musicService.addSong("Rock Song: Hotel California");

        userPlaylist.addSongToPlaylist(popSong);
        userPlaylist.addSongToPlaylist(rockSong);
        userPlaylist.playPlaylist();
    }
}
