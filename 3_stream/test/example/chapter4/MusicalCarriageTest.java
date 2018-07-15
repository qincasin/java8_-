package example.chapter4;

import org.junit.Assert;
import org.junit.Test;

/**
 * 类说明： 测试多重继承
 *
 * @author: Casin
 * @Create: 2018-07-15 13:21
 * @HOME: https://qincasin.github.io/
 */

public class MusicalCarriageTest {
    @Test
    public void rocksLikeACarriage(){
//        Assert.assertEquals("... from side to side", new MusicalCarriage().rock());
        Assert.assertEquals("... all over the world!", new MusicalCarriage().rock());

    }

    /*
    *
    * 类胜于接口，如果在继承链中有方法体或抽象的方法声明，那么就可以忽略接口中的定义
    * 子类胜于父类，如果一个接口继承了另一个接口，且两个接口都定义了一个默认的方法，那么子类中的定义的方法胜出
    * 没有规则三，如果以上两条规则不适用，子类要么需要实现该方法，要么将该方法声明为抽象方法
    *
    * */

    /*
    * 接口允许多重继承，却没有成员变量，抽象类可以继承成员变量，却不能多重继承
    * */
}
