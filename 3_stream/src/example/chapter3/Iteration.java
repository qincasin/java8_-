package example.chapter3;

import base.Artist;

import java.util.Iterator;
import java.util.List;

/**
 * 类说明：
 *
 * @author: Casin
 * @Create: 2018-05-13 13:58
 * @HOME: https://qincasin.github.io/
 */

public class Iteration {

    /*从外部迭代到内部迭代*/


    /**
     * 使用for循环计算来自伦敦的艺术家人数
     */
    public int externalCountArtistsFromLondon(List<Artist> allArtists){

        int count =0;
        for (Artist artist: allArtists) {
            if (artist.isFrom("London")) {
                count++;

            }
        }
        return count;
    }

    /**
     * 使用迭代器计算来自伦敦的艺术家人数
     * 外部迭代
     */
    public int externalCountArtistsFromLondonExpanded(List<Artist> allArtists){
        int count =0;
        Iterator<Artist> iterable =allArtists.iterator();
        while (iterable.hasNext()){
            Artist artist =iterable.next();
            if(artist.isFrom("London")){
                count++;
            }
        }

        return count;
    }

    /**
     * 使用内部迭代计算来自伦敦的艺术家人数
     */
    public long internalCountArtistsFromLondon(List<Artist> allArtists){
        long count =allArtists.stream().filter(artist -> artist.isFrom("London")).count();
        return count;
    }

    /**
     * 只过滤，不计数
     * @param allArtists
     */
    public void filterArtistsFromLondon(List<Artist> allArtists){
        allArtists.stream().filter(artist -> artist.isFrom("London"));
    }

    /**
     * 由于使用了惰性求职，没有输出艺术家的名字
     * @param allArtists
     */
    public void filterArtistsFromLondonPrinted(List<Artist> allArtists){
        allArtists.stream().filter(artist -> {
            System.out.println(artist.getName());
            return artist.isFrom("London");
        });
    }

    /**
     * 输出艺术家名字
     * @param allArtists
     * @return
     */
    public long externalCountArtistsFromLondonPrinted(List<Artist> allArtists){
        long count = allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                })
                .count();
        return count;
    }





}
