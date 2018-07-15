package answers.chapter3;

import base.Album;
import base.Artist;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * 类说明： 迭代
 *
 * @author: Casin
 * @Create: 2018-06-27 16:50
 * @HOME: https://qincasin.github.io/
 */

public class Question2 {

    public static int test2(List<Artist> artists){
        int totalMebers = 0;
        for (Artist artist :artists) {
            Stream<Artist> members = artist.getMembers();
            totalMebers +=members.count();
        }
        return totalMebers;
    }
    public static int countBandMembersInternal(List<Artist> artists){
        return (int)artists.stream()
                .flatMap(artist -> artist.getMembers()).count();
    }

    /**
     * ex5
     * @param album
     */
    public static void test5(Album album){
        AtomicInteger count = new AtomicInteger(0);
        System.out.println(count);
        album.getMusicians()
                .forEach(musician->count.incrementAndGet());

    }





}
