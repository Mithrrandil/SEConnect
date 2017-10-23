package com.TravisChenn.j2ee.Seconnect.dao;

import com.TravisChenn.j2ee.Seconnect.entity.base.LockElement;
import com.TravisChenn.j2ee.Seconnect.entity.example.ManagerExample;
import com.TravisChenn.j2ee.Seconnect.entity.member.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerDao {
    int countByExample(ManagerExample example);

    int deleteByExample(ManagerExample example);

    int insert(com.TravisChenn.j2ee.Seconnect.entity.member.Manager record);

    int insertSelective(com.TravisChenn.j2ee.Seconnect.entity.member.Manager record);

    List<Manager> selectByExample(ManagerExample example);

    List<Manager> selectByPrimaryKey(Integer id);

    List<LockElement> selectByPrimaryKeyWithLockNum(Integer id);

    void batchDeleteByIDS(List<String> IDS);

    int updateByExampleSelective(@Param("record") com.TravisChenn.j2ee.Seconnect.entity.member.Manager record, @Param("example") ManagerExample example);

    int updateByExample(@Param("record") com.TravisChenn.j2ee.Seconnect.entity.member.Manager record, @Param("example") ManagerExample example);

    int updateByPrimaryKeySelective(com.TravisChenn.j2ee.Seconnect.entity.member.Manager record);

    int updateByPrimaryKey(com.TravisChenn.j2ee.Seconnect.entity.member.Manager record);
}