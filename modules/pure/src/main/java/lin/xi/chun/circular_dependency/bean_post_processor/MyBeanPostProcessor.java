package lin.xi.chun.circular_dependency.bean_post_processor;


import lin.xi.chun.circular_dependency.service.AService;
import lin.xi.chun.circular_dependency.service.BService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author lin.xc
 * @date 2020/8/11
 **/
@Slf4j
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if(o instanceof AService || o instanceof BService){
            log.info("postProcessBeforeInitialization---不做处理，直接返回这个bean：{}", o);
        }else{
            log.debug("postProcessBeforeInitialization---不做处理，直接返回这个bean：{}", o);
        }
        return o;
    }

    /**
     * 改下下面两个参数名，使易于理解
     * */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("AService")){
            log.info("postProcessAfterInitialization --- bean = {}", bean);
            /**
             * 之前说的是如果这个bean没用AOP的话，互相依赖，那么只要二级缓存就够了，
             * 因为从map缓存中获取的A的原始对象，后面经过设置之后和一开始放到B里面是同个对象。
             * 这里为了模拟AOP造成的影响（对Bean进行加工，换了一个Bean），采用重新定义一个新的Bean，然后返回。
             * 这样再启动main方法的时候就报错了，之所以报错就是：注入给B的A和放到单例池里的A不是同个对象。Spring会去验证的
             * 此时为了处理这种情况，就应运而生了Spring的三级缓存
             * Map<beanName,ObjectFactory>
             * */
            AService aService = new AService();
            return aService;
        }
        return bean;
    }
}
