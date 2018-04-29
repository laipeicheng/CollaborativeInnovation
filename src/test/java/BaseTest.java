import com.zhc.collaborativeinnovation.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml" })
public class BaseTest {

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
}
