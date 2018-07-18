package example.chapter4;

/**
 * 类说明：继承ParentImpl
 *
 * @author: Casin
 * @Create: 2018-07-15 13:06
 * @HOME: https://qincasin.github.io/
 */

public class OverrideParent extends ParentImpl {
    @Override
    public void welcome() {
        message("Class Parent: Hi!");
    }
}
