import javax.swing.text.DateFormatter;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.function.BinaryOperator;

/**
 * 类说明：如何辨别Lambda表达式
 *
 * @author: Casin
 * @Create: 2018-05-10 15:48
 * @HOME: https://qincasin.github.io/
 */

public class Test2_3 {
    /**
     * 目标类型是值Lambda表达式锁在上下文环境的类型。
     * 比如：将Lambda表达式赋值给一个局部变量，或传递给一个方法作为参数，局部变量或方法参数的类型就是Lambda表达式的目标类型
     * @param args
     */
    public static void main(String[] args) {
        //不含参数，只有一个run方法，没有参数，且返回值为void
        Runnable noArguments =()-> System.out.println("hello world");


        //含有一个参数
        ActionListener oneArgument =event -> System.out.println("botton clicked");

        //大括号表明Lambda表达式从何处开始，到哪里结束
        Runnable multiStatement =()->{
            System.out.print("Hello");
            System.out.println(" World");
        };

        //创建了一个函数，用来计算两个数字相加的结果，变量add的类型是BinaryOperator<Long>
        //它不是两个数字的和，而是将两个数字相加的那行代码
        BinaryOperator<Long> add =(x,y)->x+y;

        //显示声明参数类型
        BinaryOperator<Long> addExplicit =(Long x,Long y) ->x+y;

        noArguments.run();

        System.out.println(add);
        Calendar cal =Calendar.getInstance();
        cal.set(Calendar.YEAR,1970);
        cal.set(Calendar.MONDAY,Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH,1);
        String formatted =Test2_3.formatter.get().getFormat().format(cal.getTime());
        System.out.println(formatted);

        Runnable helloWorld =()-> System.out.println("hello world");
        helloWorld.run();

    }

    public final static ThreadLocal<DateFormatter> formatter =ThreadLocal.withInitial(()->new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));



}
