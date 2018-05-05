import com.google.gson.Gson;
import com.zhc.collaborativeinnovation.service.ArticleService;
import com.zhc.collaborativeinnovation.service.impl.ArticleServiceImpl;
import com.zhc.collaborativeinnovation.vo.*;
import com.zhc.collaborativeinnovation.service.UserService;
import com.zhc.core.service.BaseService;
import com.zhc.core.service.impl.BaseServiceImpl;
import com.zhc.core.util.EncryptUtil;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml" })
public class BaseTest {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("baseService")
    private BaseService<Role> roleService;

    @Autowired
    @Qualifier("articleService")
    private ArticleService articleService;


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


    @Test
    public void testGetRole(){
	    Role role = roleService.get(Role.class, 2);
        System.out.println(role);
    }

    @Test
    public void testDeleteRole(){

        /**
         * Role role = new Role(2,"");
         * 必须从数据库中获得一方的对象,才能级联删除对应的多方的数据
         * 实际意义为调用一方中的多方集合的clear方法清空该集合，才能删除此集合在数据库中对应的数据
         * 否则为将多方的外键设为null，断开关系
         */
        Role role = roleService.get(Role.class, 2);
        roleService.delete(role);
    }

    @Test
    public void testDeleteUser(){
        User user = new User();
        user.setUsername("asdf");
        userService.delete(user);
    }

    @Test
    public void testGetArticle(){
        List<Article> list = articleService.listSortByPageview();
        System.out.println(list);
    }

}
