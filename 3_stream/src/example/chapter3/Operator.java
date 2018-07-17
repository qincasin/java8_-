package example.chapter3;

import base.Track;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类说明： 常用流操作
 *
 * @author: Casin
 * @Create: 2018-05-13 18:27
 * @HOME: https://qincasin.github.io/
 */

public class Operator {

    /*Collectors.toList()操作*/

    /**
     * 通常的一个例子
     */
    @Test
    public void test(){
        List<String> collected = Stream.of("a","b","c").collect(Collectors.toList());
        System.out.println(collected);
    }

    /*Map操作*/

    /**
     * map 原始方式
     * 使用for循环将字符串转换为大写
     */
    @Test
    public void test3_8(){
        List<String> collected = new ArrayList<>();
        for(String string: Arrays.asList("a","b","hello")){
            String uppercaseString = string.toUpperCase();
            collected.add(uppercaseString);
        }
        System.out.println(collected);
    }

    /**
     * map 操作转换大写
     * 使用map操作将字符串转换为大写形式
     */
    @Test
    public void test3_9(){
        List<String> collected = Stream.of("a","b","hello")
                .map(value->value.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(collected);
    }

    /*接下来是filter操作*/

    /**
     *
     * 使用原始的方式
     * 使用循环遍历列表，使用条件语句做判断
     * 找出一组字符串中以数字开头的字符串，比如1abc和abc ，其中1abc就是符合条件的字符串
     */
    @Test
    public void test3_10(){
        List<String> beginningWithNumbers = new ArrayList<>();
        for(String value:Arrays.asList("1abc","abc","abc1")){
            if(Character.isDigit(value.charAt(0))){
                beginningWithNumbers.add(value);
            }
        }
        System.out.println(beginningWithNumbers);
    }

    /**
     *
     * 使用流进行操作
     * 函数式风格过滤操作(也就是 predicate 操作 ,返回 true 或者 false)
     */
    @Test
    public void test3_11(){
        List<String> beginningWithNumbers = Stream.of("1abc","abc","abc1")
                .filter(value->Character.isDigit(value.charAt(0)))
                .collect(Collectors.toList());
        System.out.println(beginningWithNumbers);
    }

    /*flatMap操作*/


    /**
     * 包含多个列表的stream
     * 假如有一个包含多个列表的流 ， 现在希望得到所有数字的序列。
     * 将两个列表中中的所有数据汇聚在一起输出出来
     * [7, 2, 3, 4]
     */
    @Test
    public void test3_12(){
        List<Integer> together = Stream.of(Arrays.asList(7,2),Arrays.asList(3,4))
                .flatMap(number-> number.stream())
                .collect(Collectors.toList());
        System.out.println(together);
    }

    /*3.3.5 max和min */

    /**
     * 使用Stream 查找对端曲目
     * 查找专辑中最短曲目的所用的代码，使用max和min操作
     * 输出：曲目二的地址
     */
    @Test
    public void test3_13(){
        List<Track> tracks = Arrays.asList(
                new Track("Bakai",524),
                new Track("Violets for Your Furs",378),
                new Track("Time Was",451));
        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get(); //如果为空则报异常该值不存在(No value present)，如果不为空则该值存在
        System.out.println(tracks.get(1));
        System.out.println(shortestTrack);
        Assert.assertEquals(tracks.get(1),shortestTrack);
    }


    /*3.3.6 通用模式*/

    /**
     * 使用for循环查找最短曲目
     * 输出：378
     */
    @Test
    public void test3_14(){
        List<Track> tracks = Arrays.asList(
                new Track("Bakai",524),
                new Track("Violets for Yours Furs",378),
                new Track("Time Was",451));
        Track shortestTrack = tracks.get(0);
        for(Track track :tracks){
            if(track.getLength()<shortestTrack.getLength()){
                shortestTrack=track;
            }
        }
        System.out.println(shortestTrack.getLength());
    }

    /*reduce 模式*/
//    @Test
//    public void test3_15(){
//        Object accumulator = initialValue;
//        for (Object element : collection){
//            accumulator=combine(accumulator,element);
//        }
//    }

    /* reduce 操作*/

    /**
     * 使用reduce 求和
     * 求给定三个数字 1 2 3 求这三个数字的和 使用reduce操作
     * 其实reduce操作就是之前所讲的BinaryOperator
     * 输出：6
     */
    @Test
    public void test3_16(){
        //lambda表达式的返回值是最新的acc，是上一轮acc的值和当前元素相加的结果
        int count = Stream.of(1,2,3).reduce(0,(acc,element)->acc+element);
        System.out.println(count);
    }
    /**
     * 展开reduce操作
     * 将reduce的操作过程进行展开
     * 输出结果：6
     */
    @Test
    public void test3_17(){
        BinaryOperator<Integer> accumulator = (acc,element)->acc+element;
        int count =accumulator.apply(
               accumulator.apply(
                       accumulator.apply(0,1),
               2),
        3);
        System.out.println(count);
    }

    /**
     * 使用命令式编程方式求和
     * 对于集合来，循环在外部，且需要手动更新变量
     * 输出结果：6
     */
    @Test
    public void test3_18(){
        int acc =0;
        for (Integer element:Arrays.asList(1,2,3)){
            acc=acc+element;
        }
        System.out.println(acc);
    }
}
