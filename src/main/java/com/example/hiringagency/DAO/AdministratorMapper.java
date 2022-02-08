package com.example.hiringagency.DAO;

import com.example.hiringagency.domain.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdministratorMapper {

    void addStaff(String FirstName, String LastName, String Username, String Password, String PostalAddress, String PhoneNumber, String Email);

    Long sumUserNum();

    List<Users> selectAllStaff();
}
