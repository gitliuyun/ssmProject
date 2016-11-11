package User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sy.model.User;
import sy.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class TestUser {
	
	private UserService userService;

	@Test
	public void testUser(){
		Integer id = new Integer(1);
		User user = userService.getUserById(id);
		System.out.println(user.getName());
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
