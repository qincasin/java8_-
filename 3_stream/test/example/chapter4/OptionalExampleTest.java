package example.chapter4;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * 类说明： OPtional判断null
 *
 * @author: Casin
 * @Create: 2018-07-15 13:33
 * @HOME: https://qincasin.github.io/
 */

public class OptionalExampleTest {
    @Test
    public void examples(){
        Optional<String> a = Optional.of("a");
        Assert.assertEquals("a",a.get());

        Optional emptyOptional = Optional.empty();
        Optional alseEmpty = Optional.ofNullable(null);
        //isPresent() 方法表示一个Optional对象里是否有值
        Assert.assertFalse(emptyOptional.isPresent());

        Assert.assertTrue(a.isPresent());
        Assert.assertEquals("b", emptyOptional.orElse("b"));
        Assert.assertEquals("c", emptyOptional.orElseGet(() -> "c"));


    }

    @Test
    public void examples2(){
        Optional<String> b = Optional.ofNullable(null);
        if(b.isPresent()){
            System.out.println("1111");
        }else {
            System.out.println("bbbb");
        }
    }




}
