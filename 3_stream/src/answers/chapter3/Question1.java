package answers.chapter3;

import base.Album;
import base.Artist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类说明： 练习1常用流操作
 *
 * @author: Casin
 * @Create: 2018-06-27 16:20
 * @HOME: https://qincasin.github.io/
 */

public class Question1 {
    /**
     * 流计算和
     * @param numbers
     * @return
     */
    public static int addUp(Stream<Integer> numbers){
        return numbers.reduce(0,(acc,x)->acc+x);
    }

    /**
     * 使用flatMap合并成一个stream然后取出其中的姓名和国籍
     * @param artists
     * @return
     */
    public static List<String> getNamesAndOrigins(List<Artist> artists){
        return artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(),artist.getNationality()))
                .collect(Collectors.toList());
    }

    /**
     * 返回最多包含3首歌曲的专辑
     * @param albums
     * @return
     */
    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> albums){
        return albums.stream()
                //.filter(album -> album.getTracks().count()<=3)
                .filter(album -> album.getTrackList().size()<=3)
                .collect(Collectors.toList());
    }
}
