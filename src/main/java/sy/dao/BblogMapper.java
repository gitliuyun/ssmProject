package sy.dao;

import sy.model.Bblog;

public interface BblogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bblog record);

    int insertSelective(Bblog record);

    Bblog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bblog record);

    int updateByPrimaryKeyWithBLOBs(Bblog record);

    int updateByPrimaryKey(Bblog record);
}