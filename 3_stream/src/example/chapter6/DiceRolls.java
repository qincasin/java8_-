package example.chapter6;

import org.junit.Test;

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
//@State(Scope.Benchmark)
//@BenchmarkMode(Mode.AverageTime)
public class DiceRolls {
    private static final int N = 100000000;

//    public static void main(String[] ignore) throws IOException, RunnerException {
//        final String[] args = {
//                ".*DiceRolls.*",
//                "-wi",
//                "5",
//                "-i",
//                "5"
//        };
//        Main.main(args);
//    }

    /**
     *
     * 串行化模拟蒙特卡洛模拟法掷骰子事件
     * @return
     */
//    @GenerateMicroBenchmark
//    @Test
    public Map<Integer,Double> serialDiceRolls(){
        double fraction = 1.0/N;
        return IntStream.range(0,N)
                .mapToObj(twoDiceThrows())
                .collect(Collectors.groupingBy(side->side,Collectors.summingDouble(n->fraction)));
    }
//    @GenerateMicroBenchmark
    public Map<Integer,Double> parallelDiceRolls(){
        double fraction =1.0/N;
        return IntStream.range(0,N)
                .parallel()
                .mapToObj(twoDiceThrows())
                .collect(Collectors.groupingBy(side->side,Collectors.summingDouble(n->fraction)));
    }

    public static IntFunction<Integer> twoDiceThrows() {
        return i->{
            ThreadLocalRandom random =ThreadLocalRandom.current();
            int firstThrow = random.nextInt(1,7);
            int secondThrow = random.nextInt(1,7);
            return firstThrow+secondThrow;
        };
    }

    public static void main(String[] args) {
        DiceRolls a = new DiceRolls();
        Map<Integer,Double> result = a.parallelDiceRolls();
        System.out.println(result);


        Map<Integer,Double> result2 = a.serialDiceRolls();
        System.out.println(result2);

    }





}
