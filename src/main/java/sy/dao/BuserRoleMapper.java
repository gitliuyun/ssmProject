package sy.dao;

import sy.model.BuserRole;

public interface BuserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BuserRole record);

    int insertSelective(BuserRole record);

    BuserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BuserRole record);

    int updateByPrimaryKey(BuserRole record);
}