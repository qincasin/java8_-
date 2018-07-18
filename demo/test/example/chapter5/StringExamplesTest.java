package example.chapter5;

import base.Artist;
import base.SampleData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * 类说明： 字符串测试
 *
 * @author: Casin
 * @Create: 2018-07-15 16:34
 * @HOME: https://qincasin.github.io/
 */

public class StringExamplesTest {
    /**
     * 测试StringJoiner方法
     */
    @Test
    public void beatlesExample(){
        //StringJoiner()适用于循环拼接
        StringJoiner joiner = new StringJoiner(", ","[","]");
        joiner.add("John");
        joiner.add("Paul");
        joiner.add("Ringo");
        Assert.assertEquals("[John, Paul, Ringo]", joiner.toString());
    }

    /**
     * 测试数据  [John Coltrane, John Lennon, The Beatles]
     */
    @Test
    public void allStringJoins(){
        List<Function<List<Artist>,String>> formatters = Arrays.asList(
//                StringExamples::formatArtists,
//                StringExamples::formatArtistsForLoop,
//                StringExamples::formatArtistsRefactor1,
                StringExamples::formatArtistsRefactor2
//                StringExamples::formatArtistsRefactor3,
//                StringExamples::formatArtistsRefactor4,
//                StringExamples::formatArtistsRefactor5
        );

        formatters.forEach(formatter->{
            System.out.println("input："+SampleData.getThreeArtists().toString());
            String result = formatter.apply(SampleData.getThreeArtists());
            System.out.println(result);
            Assert.assertEquals("[John Coltrane, John Lennon, The Beatles]",result);
        });
    }
    @Test
    public void test2(){
        ThreadLocalRandom random =ThreadLocalRandom.current();
        int firstThrow = random.nextInt(1,7);
        int secondThrow = random.nextInt(1,7);
        System.out.println(firstThrow);
        System.out.println(secondThrow);
        System.out.println(firstThrow+secondThrow);
        IntStream.range(0,10).forEach(System.out::print);
    }

}
