package example;

import base.SampleData;
import example.chapter3.Iteration;
import org.junit.Test;

/**
 * 类说明： 测试迭代
 *
 * @author: Casin
 * @Create: 2018-05-13 14:57
 * @HOME: https://qincasin.github.io/
 */

public class IterationTest {

    /**
      测试：3-1
     * 使用for循环计算来自伦敦的艺术家人数
     */
    @Test
    public void externalCountArtistsFromLondonTest(){
        Iteration iteration = new Iteration();
        int count = iteration.externalCountArtistsFromLondon(SampleData.membersOfTheBeatles);
        System.out.println(count);
    }

    /**
     * 使用迭代器计算来自伦敦的艺术家人数
     */
    @Test
    public void externalCountArtistsFromLandonExpandedTest(){
       Iteration iteration = new Iteration();
       int count = iteration.externalCountArtistsFromLondonExpanded(SampleData.membersOfTheBeatles);
        System.out.println(count);
    }

    /**
     * 使用内部迭代计算来自伦敦的艺术家人数
     */
    @Test
    public void internalCountArtistsFromLondon(){
        Iteration iteration = new Iteration();
        long count = iteration.internalCountArtistsFromLondon(SampleData.membersOfTheBeatles);
        System.out.println(count);
    }

    /**
     * 只过滤，不计数
     */
    @Test
    public void filterArtistsFromLondonTest(){
        Iteration iteration = new Iteration();
        iteration.filterArtistsFromLondon(SampleData.membersOfTheBeatles);
    }

    /**
     * 惰性求值方法，无输出结果
     */
    @Test
    public void lazyPrintOuts(){
        Iteration iteration = new Iteration();
        iteration.filterArtistsFromLondonPrinted(SampleData.membersOfTheBeatles);
    }

    /**
     * 及早求值方法
     */
    @Test
    public void evaluatedPrintOuts(){
        Iteration iteration = new Iteration();
        iteration.externalCountArtistsFromLondonPrinted(SampleData.membersOfTheBeatles);
    }

}
