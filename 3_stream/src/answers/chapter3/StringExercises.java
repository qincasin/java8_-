package answers.chapter3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 类说明： 第六题和第七题字符串问题
 *
 * @author: Casin
 * @Create: 2018-06-27 20:39
 * @HOME: https://qincasin.github.io/
 */

public class StringExercises {

    /**
     * 获取字符串中小写字母的个数，参照String对象中的chars方法
     * @param str
     * @return
     */
    public static int countLowercaseLetters(String str){
        return(int) str.chars()
                .filter(Character::isLowerCase)
                .count();
    }

    /**
     *在一个字符串列表中，找出包含最多小写字母的字符串，对于空列表，返回Optional<String>对象
     * @param strings
     * @return
     */
    public static Optional<String> mostLowercaseString(List<String> strings){
        return strings.stream()
                .max(Comparator.comparing(StringExercises::countLowercaseLetters));
    }
}
