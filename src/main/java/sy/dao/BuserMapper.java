package sy.dao;

import sy.model.Buser;

public interface BuserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Buser record);

    int insertSelective(Buser record);

    Buser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Buser record);

    int updateByPrimaryKey(Buser record);
}