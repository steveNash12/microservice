package xyz.songxl.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;
import xyz.songxl.service.Testb;

/**
 * @author songxl
 * @create 2019-07-18 20:00
 * @desc  实现  BeanFactoryPostProcessor 接口  扩展 spring bean 功能
 **/

@Component
public class SongxlBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//
        GenericBeanDefinition testa = (GenericBeanDefinition) beanFactory.getBeanDefinition("testa");
        testa.setBeanClass(Testb.class); // 修改bean的实现类
        testa.setInitMethodName("Hello"); // 初始化方法

    }
}
