package answers.chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * 类说明： 测试进阶练习1
 *
 * @author: Casin
 * @Create: 2018-06-27 21:35
 * @HOME: https://qincasin.github.io/
 */

public class MapUsingReduceTest {


    /**
     * 测试空
     */
    @Test
    public void emptyList(){
        assertMapped(Function.identity(), Collections.emptyList(),Collections.emptyList());
    }

    /**
     * 测试恒等式
     */
    @Test
    public void identityMapsToItself(){
        assertMapped((Integer x)->x, Arrays.asList(1,2,3),Arrays.asList(1,2,3));
    }


    /**
     * 自增测试数字
     */
    @Test
    public void incrementingNumbers(){
        assertMapped((Integer x)->x+2,Arrays.asList(1,2,3),Arrays.asList(3,4,5));
    }

    /**
     *
     * @param mapper  高阶函数
     * @param input   输入
     * @param expectedOut 期待输出
     * @param <I>
     * @param <O>
     */
    private <I,O> void assertMapped(Function<I,O> mapper, List<I> input,List<O> expectedOut){
        List<O> output = MapUsingReduce.map(input.stream(),mapper);
        Assert.assertEquals(expectedOut,output);
        //对比输出
        List<O> parallelOutput = MapUsingReduce.map(input.parallelStream(),mapper);
        Assert.assertEquals(expectedOut,parallelOutput);
    }
}
