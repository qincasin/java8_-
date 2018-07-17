package base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * 类说明： 简单数据
 *
 * @author: Casin
 * @Create: 2018-05-13 14:46
 * @HOME: https://qincasin.github.io/
 */

public class SampleData {


    //创作音乐的个人或者团队
    public static final Artist johnColtrane = new Artist("John Coltrane", "US");
    //manyTrackAlbum专辑
    public static final Album manyTrackAlbum = new Album("sample Short Album",
            asList(
                    new Track("short track 1", 20), new Track("short track 2", 16),
                    new Track("short track 3", 18), new Track("short track 4", 77),
                    new Track("short track 5", 10)
            ),
            //属于johnColtrane乐队
            asList(johnColtrane));

    //manyTrackAlbum2专辑
    public static final Album manyTrackAlbum2 = new Album("sample Short Album2",
            asList(
                    new Track("short track 1 one ", 61), new Track("short track 2 two ", 64),
                    new Track("short track 3 three ", 59), new Track("short track 4 four ", 68),
                    new Track("short track 5 five ", 70)),
            //属于johnColtrane乐队
            asList(johnColtrane));
    public static final List<Album> ALBUMS = Stream.of(manyTrackAlbum,manyTrackAlbum2).collect(Collectors.toList());

    public static final Artist johnLennon = new Artist("John Lennon", "UK");
    public static final Artist paulMcCartney = new Artist("Paul McCartney", "UK");
    public static final Artist georgeHarrison = new Artist("George Harrison", "UK");
    public static final Artist ringoStarr = new Artist("Ringo Starr", "UK");

    public static final Artist ringoStarrLondon = new Artist("Ringo Starr London", "London");

    public static final List<Artist> membersOfTheBeatles = Arrays.asList(johnLennon, paulMcCartney, georgeHarrison, ringoStarr,ringoStarrLondon);

    public static final Artist theBeatles = new Artist("The Beatles", membersOfTheBeatles, "UK");

    public static final Album aLoveSupreme = new Album("A Love Supreme", asList(new Track("Acknowledgement", 467), new Track("Resolution", 442)), asList(johnColtrane));

    public static final Album sampleShortAlbum = new Album("sample Short Album", asList(new Track("short track", 30)), asList(johnColtrane));




    public static Stream<Album> albums = Stream.of(aLoveSupreme);

    public static Stream<Artist> threeArtists() {
        return Stream.of(johnColtrane, johnLennon, theBeatles);
    }

    public static List<Artist> getThreeArtists() {
        return Arrays.asList(johnColtrane, johnLennon, theBeatles);
    }
}
