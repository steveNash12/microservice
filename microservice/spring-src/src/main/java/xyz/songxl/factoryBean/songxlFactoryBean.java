package xyz.songxl.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import xyz.songxl.spring.SongxlRegistrar;

/**
 * @author songxl
 * @create 2019-07-19 14:24
 * @desc ${DESCRIPTION}
 **/
@Component
public class songxlFactoryBean  implements FactoryBean {
    /**
     * 返回对象信息
     * @return
     * @throws Exception
     */
    @Override
    public Object getObject() throws Exception {
        return new SongxlRegistrar();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

}
