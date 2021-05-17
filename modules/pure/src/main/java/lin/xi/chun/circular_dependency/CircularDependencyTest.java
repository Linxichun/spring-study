package lin.xi.chun.circular_dependency;

import lin.xi.chun.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lin.xc
 * @date 2020/8/11
 **/
public class CircularDependencyTest {
    /**
     * 循环依赖问题测试
     * */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean("AService"));
        System.out.println(context.getBean("BService"));
    }
}
