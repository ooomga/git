package net.juntech.dao.mapper;

import java.util.List;
import net.juntech.entity.RoleEntity;
import net.juntech.entity.RoleEntityCriteria;
import org.apache.ibatis.annotations.Param;

public interface RoleEntityMapper {
    int countByExample(RoleEntityCriteria example);

    int deleteByExample(RoleEntityCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(RoleEntity record);

    int insertSelective(RoleEntity record);

    List<RoleEntity> selectByExample(RoleEntityCriteria example);

    RoleEntity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoleEntity record, @Param("example") RoleEntityCriteria example);

    int updateByExample(@Param("record") RoleEntity record, @Param("example") RoleEntityCriteria example);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);

    RoleEntity selectByExampleForOne(RoleEntityCriteria example);
}