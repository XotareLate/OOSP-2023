import java.util.ArrayList;
import java.util.List;

// Компонент - абстрактный класс для музыкальных элементов
interface MusicComponent {
    void play();
}

// Лист - конкретная реализация компонента (музыкальный трек)
class Song implements MusicComponent {
    private String title;

    public Song(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing song: " + title);
    }
}

// Контейнер - абстрактный класс для группировки музыкальных элементов
interface MusicContainer extends MusicComponent {
    void add(MusicComponent component);
    void remove(MusicComponent component);
}

// Композит - конкретная реализация контейнера (альбом)
class Album implements MusicContainer {
    private String title;
    private List<MusicComponent> tracks;

    public Album(String title) {
        this.title = title;
        this.tracks = new ArrayList<>();
    }

    @Override
    public void add(MusicComponent component) {
        tracks.add(component);
    }

    @Override
    public void remove(MusicComponent component) {
        tracks.remove(component);
    }

    @Override
    public void play() {
        System.out.println("Playing album: " + title);
        for (MusicComponent track : tracks) {
            track.play();
        }
    }
}

// Композит - конкретная реализация контейнера (плейлист)
class Playlist implements MusicContainer {
    private String title;
    private List<MusicComponent> tracks;

    public Playlist(String title) {
        this.title = title;
        this.tracks = new ArrayList<>();
    }

    @Override
    public void add(MusicComponent component) {
        tracks.add(component);
    }

    @Override
    public void remove(MusicComponent component) {
        tracks.remove(component);
    }

    @Override
    public void play() {
        System.out.println("Playing playlist: " + title);
        for (MusicComponent track : tracks) {
            track.play();
        }
    }
}

// Пример использования
public class CompositePatternExample {
    public static void main(String[] args) {
        // Создаем музыкальные треки
        MusicComponent song1 = new Song("Song 1");
        MusicComponent song2 = new Song("Song 2");
        MusicComponent song3 = new Song("Song 3");

        // Создаем альбом и добавляем в него треки
        MusicContainer album = new Album("Album 1");
        album.add(song1);
        album.add(song2);

        // Создаем плейлист и добавляем в него треки и альбом
        MusicContainer playlist = new Playlist("My Playlist");
        playlist.add(song3);
        playlist.add(album);

        // Воспроизводим плейлист
        playlist.play();
    }
}
