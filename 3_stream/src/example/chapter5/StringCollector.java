package example.chapter5;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 类说明： 创建收集器
 *
 * @author: Casin
 * @Create: 2018-07-15 19:31
 * @HOME: https://qincasin.github.io/
 */

public class StringCollector implements Collector<String,StringCombiner,String>{
    public static final Set<Characteristics> CHARACTERISTICS = Collections.emptySet();

    private final String delim;
    private final String prefix;
    private final String suffix;

    public StringCollector(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    /**
     * 创建容器的工厂
     * 收集器一开始 Supplier先创建新的容器
     * @return
     */
    @Override
    public Supplier<StringCombiner> supplier() {
        return ()->new StringCombiner(delim,prefix,suffix);
    }


    /**
     * 累加器(也就是一个函数)
     * 将当前元素叠加到收集器(流中的值叠加到容器中)
     *
     * @return
     */
    @Override
    public BiConsumer<StringCombiner, String> accumulator() {
        return StringCombiner::add;
    }

    /**
     * 合并两个容器(多个聚合为一个)
     * @return
     */
    @Override
    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }

    /**
     * 内链到方法链的末端，转换为我们想要的输出的字符串(toString)
     * @return
     */
    @Override
    public Function<StringCombiner, String> finisher() {
        return StringCombiner::toString;
    }

    /**
     * 描述收集器的对象
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        return CHARACTERISTICS;
    }
}
