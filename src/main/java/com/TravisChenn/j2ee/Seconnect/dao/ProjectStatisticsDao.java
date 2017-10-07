package com.TravisChenn.j2ee.Seconnect.dao;

import com.TravisChenn.j2ee.Seconnect.entity.ProjectStatistics;
import com.TravisChenn.j2ee.Seconnect.entity.example.ProjectStatisticsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectStatisticsDao {
    int countByExample(ProjectStatisticsExample example);

    int deleteByExample(ProjectStatisticsExample example);

    int insert(ProjectStatistics record);

    int insertSelective(ProjectStatistics record);

    List<ProjectStatistics> selectByExample(ProjectStatisticsExample example);

    int updateByExampleSelective(@Param("record") ProjectStatistics record, @Param("example") ProjectStatisticsExample example);

    int updateByExample(@Param("record") ProjectStatistics record, @Param("example") ProjectStatisticsExample example);
}