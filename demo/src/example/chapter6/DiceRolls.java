package example.chapter6;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 模拟系统
 *
 * @author casin
 * @create 2018-07-16 21:15
 **/
public class DiceRolls {
    private static final int N = 100000000;  //10亿


    /**
     *
     * 串行化模拟蒙特卡洛模拟法掷骰子事件
     * @return
     */
    public Map<Integer,Double> serialDiceRolls(){
        double fraction = 1.0/N;
        return IntStream.range(0,N)  //创建大小为N的流
                .mapToObj(twoDiceThrows())
                .collect(Collectors.groupingBy(side->side,Collectors.summingDouble(n->fraction)));
    }
    public Map<Integer,Double> parallelDiceRolls(){
        double fraction =1.0/N;
        return IntStream.range(0,N)
                .parallel()
                .mapToObj(twoDiceThrows())
                .collect(Collectors.groupingBy(side->side,Collectors.summingDouble(n->fraction)));
    }

    /**
     * 连续掷骰子事件模拟，返回两次之和
     * @return
     */
    public static IntFunction<Integer> twoDiceThrows() {
        return i->{
            //随机数生成器
            ThreadLocalRandom random =ThreadLocalRandom.current();
            int firstThrow = random.nextInt(1,7);
            int secondThrow = random.nextInt(1,7);
            return firstThrow+secondThrow;
        };
    }

    public static void main(String[] args) {
        DiceRolls a = new DiceRolls();
        Integer beginTimeParallel = TimeUtils.getTime();
        Map<Integer,Double> result = a.parallelDiceRolls();
        Integer endTimeParallel =TimeUtils.getTime();

        System.out.println("parallel:"+(endTimeParallel-beginTimeParallel));

        System.out.println(result);

        Integer beginTime = TimeUtils.getTime();
        Map<Integer,Double> result2 = a.serialDiceRolls();
        Integer endTime =TimeUtils.getTime();
        System.out.println("serial:"+(endTime-beginTime));
        System.out.println(result2);


    }





}
