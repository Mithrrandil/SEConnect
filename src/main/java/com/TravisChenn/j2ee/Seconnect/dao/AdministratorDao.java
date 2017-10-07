package com.TravisChenn.j2ee.Seconnect.dao;

import com.TravisChenn.j2ee.Seconnect.entity.example.AdministratorExample;
import com.TravisChenn.j2ee.Seconnect.entity.member.Administrator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdministratorDao {
    int countByExample(AdministratorExample example);

    int deleteByExample(AdministratorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    List<Administrator> selectByExample(AdministratorExample example);

    Administrator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByExample(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);
}