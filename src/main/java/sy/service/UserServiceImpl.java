package sy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.UserMapper;
import sy.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;
	@Override
	public User getUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
}
