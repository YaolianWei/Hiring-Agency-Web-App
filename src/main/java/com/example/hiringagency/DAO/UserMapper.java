package com.example.hiringagency.DAO;

import com.example.hiringagency.domain.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {

    /**
     * Query user and verify login based on name and password
     */
    Users login(@Param("userName") String userName, @Param("password") String password);

}
