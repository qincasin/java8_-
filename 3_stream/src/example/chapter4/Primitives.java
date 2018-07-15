package example.chapter4;

import base.Album;

import java.util.IntSummaryStatistics;

/**
 * 类说明： 基本类型
 *
 * @author: Casin
 * @Create: 2018-07-15 12:36
 * @HOME: https://qincasin.github.io/
 */

public class Primitives {
    public static void printTrackLengthStatistics(Album album) {
        IntSummaryStatistics trackLengthStats
                =album.getTracks()
                .mapToInt(track->track.getLength())
                .summaryStatistics();
        System.out.println( System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                trackLengthStats.getMax(),
                trackLengthStats.getMin(),
                trackLengthStats.getAverage(),
                trackLengthStats.getSum()));
    }
}
