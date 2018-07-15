package example;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 类说明： 第三章测试题
 *
 * @author: Casin
 * @Create: 2018-06-27 15:56
 * @HOME: https://qincasin.github.io/
 */

public class LambdaExercises {
    /**
     * 1.常用流操作
     */
    @Test
    public void _1a(){
       Stream<Integer> list =  Stream.of(1,2,3);
        System.out.println(addUp(list));
    }

    /**
     * 求和函数，计算流中的所有数之和
     * @param numbers
     * @return
     */
    public int addUp(Stream<Integer> numbers){
        return numbers.reduce(0,(acc,elment)->acc+elment);
    }
    @Test
    public void _1b(){

    }




}
