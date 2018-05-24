package com.zhc.collaborativeinnovation.directive;

import com.zhc.collaborativeinnovation.service.FavoriteService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

/**
 * 自定义freemarker指令
 * 查询当前用户是否已收藏该文章
 */
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
