package example.chapter4;

/**
 * 类说明： 默认方法实现类
 *
 * @author: Casin
 * @Create: 2018-07-15 12:51
 * @HOME: https://qincasin.github.io/
 */

public class ParentImpl implements Parent {
    private String body;

    @Override
    public void message(String body) {
        this.body = body;
    }

    @Override
    public String getLastMessage() {
        return body;
    }
}
