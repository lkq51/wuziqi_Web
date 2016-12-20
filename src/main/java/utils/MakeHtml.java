package utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lkq on 2016/12/20.
 */
public class MakeHtml{
    public void execute(){
        //doSomething
    }

    public static void main(String[] args){
        System.out.println("---begin----");
        ApplicationContext context = new ClassPathXmlApplicationContext();

        //如果配置文件中将startQuertz bean的lazy-init设置为false 则不用实例化
        context.getBean("StartQuertz");
        System.out.println("----end----");
    }
}
