package example.chapter4;

/**
 * 类说明： 用来扩展parent方法
 *
 * @author: Casin
 * @Create: 2018-07-15 12:57
 * @HOME: https://qincasin.github.io/
 */

public interface Child extends Parent {
    /**
     * 该方法重写了Parent中的默认方法
     */
    @Override
    default void welcome() {
        message("Child Hi!");
    }
}
