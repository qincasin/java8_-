package example.chapter4;

/**
 * 类说明：
 *
 * @author: Casin
 * @Create: 2018-07-15 12:48
 * @HOME: https://qincasin.github.io/
 */

public interface Parent {
    public void message(String body);

    public default void welcome(){
        message("Parent : Hi!");
    }
    public String getLastMessage();

}
