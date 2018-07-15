package example.chapter4;

import base.SampleData;
import org.junit.Test;

/**
 * 类说明： 基本类型测试类
 *
 * @author: Casin
 * @Create: 2018-07-15 12:40
 * @HOME: https://qincasin.github.io/
 */

public class PrimitivesTest {
    @Test
    public void albumStatistics(){
        Primitives.printTrackLengthStatistics(SampleData.aLoveSupreme);
    }
}
