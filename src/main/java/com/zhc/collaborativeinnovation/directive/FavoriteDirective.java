package com.zhc.collaborativeinnovation.directive;

import com.zhc.collaborativeinnovation.service.ArticleService;
import com.zhc.collaborativeinnovation.service.FavoriteService;
import com.zhc.collaborativeinnovation.service.UserService;
import com.zhc.collaborativeinnovation.service.impl.ArticleServiceImpl;
import com.zhc.collaborativeinnovation.service.impl.UserServiceImpl;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.collaborativeinnovation.vo.User;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

public class FavoriteDirective implements TemplateDirectiveModel {

    private FavoriteService favoriteService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-bean.xml", "classpath:applicationContext-hibernate.xml");

        TemplateScalarModel username = (TemplateScalarModel) map.get("username");
        TemplateScalarModel articleid = (TemplateScalarModel) map.get("articleid");

        templateModels[0] = TemplateBooleanModel.FALSE;

        if (username != null && !"".equals(username.getAsString()) && articleid != null && !"".equals(articleid.getAsString())) {
            int id = Integer.parseInt(articleid.getAsString());
            favoriteService = (FavoriteService) context.getBean("favoriteService");
            if (favoriteService.isFavorite(username.getAsString(), id)) {
                templateModels[0] = TemplateBooleanModel.TRUE;
            }
        }
        templateDirectiveBody.render(environment.getOut());
    }
}
