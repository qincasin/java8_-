package answers.chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

/**
 * 类说明： 第六题和第七题字符串问题
 *
 * @author: Casin
 * @Create: 2018-06-27 20:37
 * @HOME: https://qincasin.github.io/
 */

public class StringExercisesTest {

    /**
     * 空字符串测试
     */
    @Test
    public void noLowercaseLettersInAnEmptyString(){
        Assert.assertEquals(0,StringExercises.countLowercaseLetters(""));
    }

    /**
     * 正常数据
     */
    @Test
    public void countsLowercaseLetterExample(){
        Assert.assertEquals(3,StringExercises.countLowercaseLetters("aBcDeF"));
    }

    /**
     * 无符合要求的数据
     */
    @Test
    public void suppoertsNoLowercaseLetters(){
        Assert.assertEquals(0,StringExercises.countLowercaseLetters("ABCDEF"));
    }

    /*测试第七题*/
    /**
     * 传入空值
     */
    @Test
    public void noStringReturnedForEmptyList(){
        Assert.assertFalse(StringExercises.mostLowercaseString(Collections.emptyList()).isPresent());
    }

    /**
     * 正常测试
     */
    @Test
    public void findsMostLowercaseString(){
        Optional<String> result = StringExercises.mostLowercaseString(Arrays.asList("a", "abc", "ABCde"));
        System.out.println(result);
        Assert.assertEquals(result,Optional.of("abc"));
        System.out.println(Optional.of("abcd"));
    }




}
