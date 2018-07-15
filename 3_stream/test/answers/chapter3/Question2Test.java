package answers.chapter3;

import base.Artist;
import base.SampleData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 类说明： 第二道题目
 *
 * @author: Casin
 * @Create: 2018-06-27 16:58
 * @HOME: https://qincasin.github.io/
 */

public class Question2Test {

    /**
     * 测试原来的外部迭代
     */
    @Test
    public void Iterater() {
        List<Artist> artists = SampleData.getThreeArtists();

        System.out.println(artists);
        System.out.println(Question2.test2(artists));
    }

    /**
     * 测试第二个题目
     */
    @Test
    public void internal() {
        Assert.assertEquals(4, Question2.countBandMembersInternal(Arrays.asList(SampleData.johnColtrane, SampleData.theBeatles)));
    }

    @Test
    public void test5() {
        Question2.test5(null);
    }

}

