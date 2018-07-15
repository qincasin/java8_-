package answers.chapter3;

import base.Album;
import base.SampleData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 类说明： 第一题测试
 *
 * @author: Casin
 * @Create: 2018-06-27 16:37
 * @HOME: https://qincasin.github.io/
 */

public class Question1Test {
    @Test
    public void addsEmptyList(){
        int result = Question1.addUp(Stream.empty());
        Assert.assertEquals(0,result);
    }

    @Test
    public void addListWithValues(){
        int result = Question1.addUp(Stream.of(1,3,-2));
        Assert.assertEquals(2,result);
    }

    @Test
    public void extractsNamesAndOriginsOfArtis(){
        List<String> nameAndOrigins = Question1.getNamesAndOrigins(SampleData.getThreeArtists());
        System.out.println(nameAndOrigins);
        Assert.assertEquals(Arrays.asList( "John Coltrane","US", "John Lennon", "UK", "The Beatles", "UK"),nameAndOrigins);
    }

    @Test
    public void findsShortAlbums(){
        List<Album> input = Arrays.asList(SampleData.manyTrackAlbum,SampleData.sampleShortAlbum, SampleData.aLoveSupreme);
        List<Album> result = Question1.getAlbumsWithAtMostThreeTracks(input);
        Assert.assertEquals(result, Arrays.asList(SampleData.sampleShortAlbum, SampleData.aLoveSupreme));

    }
}
