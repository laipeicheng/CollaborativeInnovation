package com.zhc.collaborativeinnovation.service.impl;

import com.zhc.collaborativeinnovation.dao.*;
import com.zhc.collaborativeinnovation.service.SearchService;
import com.zhc.collaborativeinnovation.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("searchService")
public class SearchServiceImpl implements SearchService {

    private Logger log = LoggerFactory.getLogger("MainLogger");

    @Autowired
    @Qualifier("searchDao")
    private SearchDao searchDao;

    @Autowired
    @Qualifier("newsDao")
    private NewsDao newsDao;

    @Autowired
    @Qualifier("needsDao")
    private NeedsDao needsDao;

    @Autowired
    @Qualifier("articleDao")
    private ArticleDao articleDao;

    @Autowired
    @Qualifier("policyDao")
    private PolicyDao policyDao;

    @Override
    public List<String> getConditionList(int page, int pageSize, String keyword) {
        StringBuffer sb = new StringBuffer(keyword);
        sb.insert(0, '%');
        sb.insert(sb.length(), '%');
        keyword = sb.toString();
        log.info("keyword:{}", keyword);
        return searchDao.getConditionList(page, pageSize, keyword);
    }

    @Override
    public List<Result> getResultList(int page, int pageSize, String keyword, String condition) {
        List<Result> resultList = new ArrayList<Result>();
        String hql = null;
        StringBuffer sb = new StringBuffer(keyword);
        sb.insert(0, '%');
        sb.insert(sb.length(), '%');
        keyword = sb.toString();
        switch (condition) {
            case "article":
                hql = "from Article where title like ? or summary like ?";
                List<Article> articleList = articleDao.findByPage(hql, page-1, pageSize, keyword, keyword);
                for (Article article : articleList) {
                    Result result = new Result();
                    result.setUrl("article?article.articleid=" + article.getArticleid());
                    result.setTitle(article.getTitle());
                    result.setSummary(article.getSummary());
                    result.setPublishtime(article.getPublishtime());
                    resultList.add(result);
                }
                break;
            case "needs":
                hql = "from Needs where title like ?";
                List<Needs> needsList = needsDao.findByPage(hql, page-1, pageSize, keyword);
                for (Needs needs : needsList) {
                    Result result = new Result();
                    result.setUrl("needs?needs.id=" + needs.getId());
                    result.setTitle(needs.getTitle());
                    result.setSummary("");
                    result.setPublishtime(needs.getPublishtime());
                    resultList.add(result);
                }
                break;
            case "news":
                hql = "from News where title like ? or summary like ?";
                List<News> newsList = newsDao.findByPage(hql, page-1, pageSize, keyword, keyword);
                for (News news : newsList) {
                    Result result = new Result();
                    result.setUrl("news?news.id=" + news.getId());
                    result.setTitle(news.getTitle());
                    result.setSummary(news.getSummary());
                    result.setPublishtime(news.getPublishtime());
                    resultList.add(result);
                }
                break;
            case "policy":
                hql = "from Policy where title like ?";
                List<Policy> policyList = policyDao.findByPage(hql, page-1, pageSize, keyword);
                for (Policy policy : policyList) {
                    Result result = new Result();
                    result.setUrl("policy?policy.id=" + policy.getId());
                    result.setTitle(policy.getTitle());
                    result.setSummary("");
                    result.setPublishtime(policy.getPublishtime());
                    resultList.add(result);
                }
                break;
            default:
                break;
        }
        return resultList;
    }
}
