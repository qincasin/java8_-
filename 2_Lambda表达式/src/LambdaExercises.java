import org.junit.Test;

import javax.swing.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * 类说明：
 *
 * @author: Casin
 * @Create: 2018-05-11 18:05
 * @HOME: https://qincasin.github.io/
 */

public class LambdaExercises {

    @Test
    public void _3a(){
        Runnable helloWorld =()-> System.out.println("hello World");
        helloWorld.run();
    }

    @Test
    public void _3b(){
        JButton button = new JButton();
        button.addActionListener(event->
                System.out.println(event.getActionCommand()));
    }

    @Test
    public void _3c(){
        //No
        //check(x -> x > 5);
    }

   public boolean check(Predicate<Integer> predicate){
       System.out.println("wat?");
       return true;
   }

   interface InPred{
       boolean test(Integer value);
   }


    private boolean check(IntPredicate predicate) {
        return true;
    }
}
