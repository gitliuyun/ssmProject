package sy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.model.User;
import sy.service.UserService;

/*@Controller
@RequestMapping("/userController")
public class UserController {

	private UserService userService;
	
	@RequestMapping("/show")
	public String getUser(Integer id, HttpServletRequest request){
		User user = userService.getUserById(id);
		request.setAttribute("user", user);
		return "user";
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
*/

@Controller  
@RequestMapping("mydemo")  
public class UserController {  
    @RequestMapping(value="/getUserInfo")  
    public String getUserInfo(HttpServletRequest request){  
        String currentUser = (String)request.getSession().getAttribute("currentUser");  
        System.out.println("当前登录的用户为[" + currentUser + "]");  
        request.setAttribute("currUser", currentUser);  
        return "/user/info";  
    }  
} 