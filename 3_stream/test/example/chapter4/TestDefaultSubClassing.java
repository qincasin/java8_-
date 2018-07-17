package example.chapter4;

import org.junit.Assert;
import org.junit.Test;

/**
 * 类说明： 测试默认方法
 *
 * @author: Casin
 * @Create: 2018-07-15 12:50
 * @HOME: https://qincasin.github.io/
 */

public class TestDefaultSubClassing {
    /**
     * 断言成功 调用了默认的welcome方法中
     */
    @Test
    public void testParentDefaultUsed(){
        Parent parent =  new ParentImpl();
        parent.welcome();
        Assert.assertEquals("Parent : Hi!",parent.getLastMessage());
    }

    /**
     * 调用Child接口的客户代码
     */
    @Test
    public void childOverideDefault(){
        Child child = new ChildImpl();
        child.welcome();
        Assert.assertEquals("Child Hi!",child.getLastMessage());
    }

    /**
     * 调用的是类中的具体方法，而不是默认方法
     */
    @Test
    public void concreteBeatsDefault(){
        Parent parent = new OverrideParent();
        parent.welcome();
        Assert.assertEquals("Class Parent: Hi!",parent.getLastMessage());
    }

    /**
     * 类中重写的方法优先级高于接口中定义的默认方法
     */
    @Test
    public void concreteBeatsCloserDefault(){
        Child child = new OverrideChild();
        child.welcome();
        Assert.assertEquals("Class Parent: Hi!",child.getLastMessage());
    }


}
