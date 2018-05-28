import com.zhc.collaborativeinnovation.service.ArticleService;
import com.zhc.collaborativeinnovation.service.EnterpriseService;
import com.zhc.collaborativeinnovation.service.UserService;
import com.zhc.collaborativeinnovation.vo.*;
import com.zhc.core.dao.BaseDao;
import com.zhc.core.service.BaseService;
import com.zhc.core.util.EncryptUtil;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-*.xml"})
public class BaseTest {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("baseService")
    private BaseService<Role> roleService;

    @Autowired
    @Qualifier("baseService")
    private BaseService<Articletype> articletypeService;

    @Autowired
    @Qualifier("articleService")
    private ArticleService articleService;

    @Autowired
    @Qualifier("baseService")
    private BaseService<Reply> replyService;

    @Autowired
    private EnterpriseService enterpriseService;

    @Test
    public void testEntityToString() {
        Article article = new Article();
        System.out.println(article);
        Articletype articletype = new Articletype();
        System.out.println(articletype);
        Reply reply = new Reply();
        System.out.println(reply);
        Role role = new Role();
        System.out.println(role);
        User user = new User();
        System.out.println(user);
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("user02");
        user.setRealname("用户02");
        user.setPhone("15077774211");
        String password = "123456";
        password = EncryptUtil.encMD5(password, user.getUsername());
        user.setPassword(password);
        user.setRole(new Role(0, ""));
        userService.saveOrUpdate(user);
    }

    @Test
    public void testGetUser() {
        User user = userService.get("user01");
        System.out.println(user);
    }


    @Test
    public void testGetRole() {
        Role role = roleService.get(Role.class, 0);
        System.out.println(role);
    }

    @Test
    public void testDeleteRole() {

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
    public void testDeleteUser() {
        User user = new User();
        user.setUsername("asdf");
        userService.delete(user);
    }

    @Test
    public void testGetArticle() {
        List<Article> list = articleService.listSortByPageview();
        System.out.println(list);
    }

    @Test
    public void testGetArticleType() {
        Articletype articletype = articletypeService.get(Articletype.class, 1);
        System.out.println(articletype);
    }

    @Test
    public void testGetReply() {
        List<Reply> replyList = replyService.list(Reply.class);
        System.out.println(replyList);
    }

    @Autowired
    private BaseDao<Article> articleDao;

    @Test
    public void testPages() {
        int pages = articleDao.getPages(Article.class, 8);
        System.out.println(pages);
    }

    @Test
    public void testAddReply() {
        Reply reply = new Reply();
        User user = new User();
        user.setUsername("user03");
        reply.setUser(user);
        reply.setReplycontent("回复内容2");
        Article article = new Article();
        article.setArticleid(1);
        reply.setArticle(article);
        reply.setReplytime(new Timestamp(new Date().getTime()));
        replyService.saveOrUpdate(reply);
    }

    @Test
    public void testFavorite() {
        List<Article> articleList = articleService.favoriteList("user01", 1);
        System.out.println(articleList);
    }

    @Test
    public void testFavPages() {
        int pages = articleService.favPages("user01");
        System.out.println(pages);
    }


    @Test
    public void testGetEnterprise() {
        System.out.println(enterpriseService.getByUsername("user01"));
    }
}