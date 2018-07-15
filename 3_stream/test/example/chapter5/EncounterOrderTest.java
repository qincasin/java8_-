package example.chapter5;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * 类说明： 元素顺序
 *
 * @author: Casin
 * @Create: 2018-07-15 15:36
 * @HOME: https://qincasin.github.io/
 */

public class EncounterOrderTest {
    @Test
    public void listToStream(){
        List<Integer> numbers = Arrays.asList(1,2,3,4);
        List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());
        Assert.assertEquals(numbers,sameOrder);
    }

    @Test
    public void hashSetToStream(){
        Set<Integer> numbers = new HashSet<>(Arrays.asList(4,3,2,1));
        List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList(4,3,2,1),sameOrder);
    }
    @Ignore
    @Test
    public void hashSetToStreamSorted(){
        List<Integer> numbers = Arrays.asList(1,2,3,4);
        List<Integer> stillOrdered = numbers.stream().map(x->x+1).collect(Collectors.toList());
        //顺序得到了保留
        Assert.assertEquals(Arrays.asList(2,3,4,5),stillOrdered);
        Set<Integer> unordered = new HashSet<>();
        List<Integer> stillUnOrdered = unordered.stream().map(x->x+1).collect(Collectors.toList());
//        MatcherAssert.assertThat(stillUnOrdered, JUnitMatchers.hasItem(2));

    }




}
