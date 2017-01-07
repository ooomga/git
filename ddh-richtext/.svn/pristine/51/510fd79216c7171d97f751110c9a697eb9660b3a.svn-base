package net.juntech.dao.mapper;

import java.util.List;
import net.juntech.entity.UserEntity;
import net.juntech.entity.UserEntityCriteria;
import org.apache.ibatis.annotations.Param;

public interface UserEntityMapper {
    int countByExample(UserEntityCriteria example);

    int deleteByExample(UserEntityCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    List<UserEntity> selectByExample(UserEntityCriteria example);

    UserEntity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserEntity record, @Param("example") UserEntityCriteria example);

    int updateByExample(@Param("record") UserEntity record, @Param("example") UserEntityCriteria example);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    UserEntity selectByExampleForOne(UserEntityCriteria example);
}