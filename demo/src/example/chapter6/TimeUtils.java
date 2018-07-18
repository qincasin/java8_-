package example.chapter6;

import java.util.Calendar;

/**
 * 类说明：
 *
 * @author: Casin
 * @Create: 2018-07-18 1:18
 * @HOME: https://qincasin.github.io/
 */

public class TimeUtils {
    public static int getTime(){
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改

        int year = c.get(Calendar.YEAR);

        int month = c.get(Calendar.MONTH);

        int date = c.get(Calendar.DATE);

        int hour = c.get(Calendar.HOUR_OF_DAY);

        int minute = c.get(Calendar.MINUTE);

        int second = c.get(Calendar.SECOND);
        int time =second;
        return time;
    }
}
