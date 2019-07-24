package xyz.songxl.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author songxl
 * @create 2019-07-19 17:37
 * @desc ${DESCRIPTION}
 **/
@Mapper
public interface UserMapper {

    @Select("select * from users")
    List<Map> query();

    default  void abc(){
        System.out.println("interface default ");
    }
}
