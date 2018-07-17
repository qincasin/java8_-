package example.chapter4;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * 基本类型数据处理
 *
 * @author casin
 * @create 2018-07-17 17:20
 **/
public class NumberDemo {

    /**
     *    1.如果方法返回类型是基本数据类型,则在前面加To,例如ToLongFunction.
     *
     *    2.如果参数是基本类型,则不需要前缀加上类型名即可,例如LongFunction.
     *
     *    3.如果高阶函数使用基本类型,则在操作后加上后缀To再加上基本类型,例如mapToLong.
     *
     *    可以看出,最终结果是基本数据类型的话,那么加上To,如果参数是基本数据类型的话,那么不使用To.
     */
    public static void number() {
        List<String> ints = Arrays.asList("1", "3", "5", "7", "9", "2", "4", "6", "8");
        //获得当前数组的统计信息
        IntSummaryStatistics statistics = ints.stream()
                .mapToInt(str -> Integer.parseInt(str))
                //计算统计值 describing various summary data
                .summaryStatistics();
        System.out.printf("Max:%d, Min:%d, Ave:%.2f, Sum:%d",
                statistics.getMax(), statistics.getMin(),
                statistics.getAverage(), statistics.getSum());
        // Max:9, Min:1, Ave:5.00, Sum:45
    }
    public static void main(String[] args) {
        number();
    }


}
