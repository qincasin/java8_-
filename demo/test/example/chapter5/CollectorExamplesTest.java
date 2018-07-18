package example.chapter5;

import base.Album;
import base.Artist;
import base.SampleData;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 类说明： 测试收集器
 *
 * @author: Casin
 * @Create: 2018-07-18 0:34
 * @HOME: https://qincasin.github.io/
 */

public class CollectorExamplesTest {

    CollectorExamples examples = new CollectorExamples();

    /**
     * maxBy
     */
    @Test
    public void biggestGroupTest(){
        //输出The Beatles
        Optional<Artist> artistOptional = examples.biggestGroup(SampleData.threeArtists());
        System.out.println(artistOptional);
    }

    /**
     * averagingInt
     */
    @Test
    public void averageNumberOfTracksTest(){
        //(5+5)/2
        double avg =examples.averageNumberOfTracks(SampleData.ALBUMS);
        System.out.println(avg);
    }

    /**
     * partitioningBy()
     */
    @Test
    public void bandsAndSoloTest(){
        //{false=[John Coltrane, John Lennon], true=[The Beatles]}
        //前面是独唱，后面的乐队
        Map<Boolean , List<Artist>> map =examples.bandsAndSolo(SampleData.threeArtists());
        System.out.println(map);
    }


    /**
     * groupingBy()
     */
    @Test
    public void albumsByArtistTest(){
        //{John Coltrane=[base.Album@11028347, base.Album@14899482], John Lennon=[base.Album@21588809]}
        Map<Artist,List<Album>> map =examples.albumsByArtist(SampleData.ALBUMS3.stream());
        System.out.println(map);
    }


}
