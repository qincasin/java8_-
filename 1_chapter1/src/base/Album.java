package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类说明： 专辑，由若干曲目组成
 *
 * @author: Casin
 * @Create: 2018-05-13 13:25
 * @HOME: https://qincasin.github.io/
 */

public final class Album implements Performance {

    private String name;
    private List<Track> tracks;

    private List<Artist> musicians;

    public Album(String name, List<Track> tracks, List<Artist> musicians) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(tracks);
        Objects.requireNonNull(musicians);
        this.name = name;
        this.tracks = new ArrayList<>(tracks);
        this.musicians = new ArrayList<>(musicians);
    }



    @Override
    public String getName() {
        return name;
    }

    public Stream<Track> getTracks(){
        return tracks.stream();
    }

    public List<Track> getTrackList() {
        return Collections.unmodifiableList(tracks);
    }

    @Override
    public Stream<Artist> getMusicians(){
        return musicians.stream();
    }

    public List<Artist> getMusicianList(){
        return Collections.unmodifiableList(musicians);
    }

    public Artist getMainMusician(){
        return musicians.get(0);
    }


    public Album copy(){
        List<Track> tracks =getTracks().map(Track::copy).collect(Collectors.toList());
        List<Artist> musicians =getMusicians().map(Artist::copy).collect(Collectors.toList());
        return new Album(name,tracks,musicians);
    }





}
