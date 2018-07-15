package answers.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 类说明： 只用reduce和Lambda表达式写出实现Stream上的map操作的代码，如果不想返回stream可以返回一个list
 *
 * @author: Casin
 * @Create: 2018-06-27 21:26
 * @HOME: https://qincasin.github.io/
 */

public class MapUsingReduce {

    public static <I,O> List<O> map(Stream<I> stream, Function<I,O> mapper){
        return stream.reduce(new ArrayList<O>(),(acc,x)->{
           List<O> newAcc = new ArrayList<>(acc);
           newAcc.add(mapper.apply(x));
           return newAcc;
        },(List<O> left,List<O> right)->{
            //我们将左侧复制到新列表以避免变更它
            List<O> newLeft = new ArrayList<O>(left);
            newLeft.addAll(right);
            return newLeft;
        });
    }
}
