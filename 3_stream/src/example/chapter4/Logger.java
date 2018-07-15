package example.chapter4;

import java.util.function.Supplier;

/**
 * 类说明：
 *
 * @author: Casin
 * @Create: 2018-07-15 12:18
 * @HOME: https://qincasin.github.io/
 */

public class Logger {
    private boolean debug = true;
    public boolean isDebugEnable(){
        return debug;
    }
    public void debug(String message){
        if(isDebugEnable()){
            System.out.println(message);
        }
    }
    public void example(){
        Logger logger = new Logger();
        if(logger.isDebugEnable()){
            logger.debug("Look at this :"+expensiveOperation());
        }
    }

    private String expensiveOperation(){
        return "";
    }

    /**
     * 使用Lambda表达式实现的日志记录器
     * @param message
     */
    public void debug(Supplier<String> message){
        if(isDebugEnable()){
            debug(message.get());
        }
    }

    /**
     * 使用Lambda表达式简化日志代码
     */
    public void exapleWithLamba(){
        Logger logger = new Logger();
        logger.debug(()->"Look at this："+expensiveOperation());
    }


}
