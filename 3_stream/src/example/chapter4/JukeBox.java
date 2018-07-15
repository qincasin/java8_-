package example.chapter4;

/**
 * 类说明：
 *
 * @author: Casin
 * @Create: 2018-07-15 13:19
 * @HOME: https://qincasin.github.io/
 */

public interface JukeBox {
    public default String rock(){
        return "... from side to side";
    }
}
