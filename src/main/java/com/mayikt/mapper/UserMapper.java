package com.mayikt.mapper;

import com.mayikt.entity.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Insert("INSERT INTO `mayikt_user`.`mayikt_users` (`id`, `name`, `age`, `addres`) VALUES ({null}, #{name}, #{age}, #{addres});\n")
    int insertUser(UserEntity userEntity);
    @Delete("delete from mayikt_users where id=#{id}")
    int  deleteById(Integer id );
    @Update("UPDATE `mayikt_user`.`mayikt_users` SET  `name`=#{name}, `age`=#{age}', `addres`='河南' WHERE (`id`=#{id});")
    int updateUser(UserEntity userEntity);
    @Select("select * from mayikt_users where id=#{id}")
    UserEntity getById (Integer id);
}
