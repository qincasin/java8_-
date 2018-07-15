package example.chapter4;

/**
 * 类说明： 多继承
 *
 * @author: Casin
 * @Create: 2018-07-15 13:21
 * @HOME: https://qincasin.github.io/
 */

public class MusicalCarriage implements Carriage,JukeBox {

    /**
     * 实现中加入super语法
     * @return
     */
    @Override
    public String rock() {
        return Carriage.super.rock();
    }
}
