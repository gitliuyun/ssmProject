package sy.dao;

import sy.model.Brole;

public interface BroleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Brole record);

    int insertSelective(Brole record);

    Brole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Brole record);

    int updateByPrimaryKey(Brole record);
}