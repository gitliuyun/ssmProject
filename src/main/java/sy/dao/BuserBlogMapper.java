package sy.dao;

import sy.model.BuserBlog;

public interface BuserBlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BuserBlog record);

    int insertSelective(BuserBlog record);

    BuserBlog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BuserBlog record);

    int updateByPrimaryKey(BuserBlog record);
}