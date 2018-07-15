package example.chapter5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 类说明： 收集器测试
 *
 * @author: Casin
 * @Create: 2018-07-15 18:50
 * @HOME: https://qincasin.github.io/
 */

public class StringCombinerTest {
    private StringCombiner combiner;

    @Before
    public void before() {
        this.combiner = new StringCombiner(", ", "[", "]");

        combiner.add("A").add("B").add("C").add("D");
    }

    @Test
    public void add() throws Exception {
        Assert.assertEquals("[A, B, C, D]", combiner.toString());
    }

    @Test
    public void mergeWithOther() throws Exception {
        StringCombiner other = new StringCombiner(", ", "[", "]");

        other.add("E").add("F").add("G");

        this.combiner.merge(other);

        Assert.assertEquals("[A, B, C, D, E, F, G]", this.combiner.toString());
    }

    @Test
    public void mergeWithEmpty() {
        this.combiner.merge(new StringCombiner(", ", "[", "]"));

        Assert.assertEquals("[A, B, C, D]", this.combiner.toString());
    }

    @Test
    public void mergeSelf() throws Exception {
        Assert.assertEquals("[A, B, C, D]", this.combiner.merge(this.combiner).toString());
    }

    @Test
    public void twiceCallToString() throws Exception {
        Assert.assertEquals("[A, B, C, D]", this.combiner.toString());
        Assert.assertEquals("[A, B, C, D]", this.combiner.toString());
    }
}
