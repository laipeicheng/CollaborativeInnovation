import com.google.gson.Gson;
import com.zhc.collaborativeinnovation.vo.*;
import com.zhc.collaborativeinnovation.service.UserService;
import com.zhc.core.util.EncryptUtil;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml" })
public class BaseTest {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

	@Test
	public void testEntityToString(){
		Article article = new Article();
		System.out.println(article);
		Articletype articletype = new Articletype();
		System.out.println(articletype);
		Reply reply =new Reply();
		System.out.println(reply);
		Role role = new Role();
		System.out.println(role);
		User user = new User();
		System.out.println(user);
	}

	@Test
	public void testAddUser(){
	    User user = new User();
	    user.setUsername("admin");
	    user.setRealname("超级管理员");
	    user.setPhone("15077774211");
	    user.setEmail("15077774211@163.com");
	    String password = "admin";
        ByteSource salt = ByteSource.Util.bytes(user.getUsername());
        password = EncryptUtil.encMD5(password, salt);
	    user.setPassword(password);
	    userService.saveOrUpdate(user);
        System.out.println(user);
	}

	@Test
	public void testGetUser(){
	    User user = userService.get("admin");
        System.out.println(user);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
