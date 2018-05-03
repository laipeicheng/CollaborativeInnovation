package com.zhc.collaborativeinnovation.vo;

import com.google.gson.annotations.Expose;
import com.zhc.core.vo.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Article extends BaseEntity {

    @Id
    @Expose
    @Column(name = "articleid")
    private String articleid;

    @Expose
    @Column(name = "title")
    private String title;

    @Expose
    @Column(name = "summary")
    private String summary;

    @Expose
    @Column(name = "content")
    private String content;

    @Expose
    @Column(name = "pageview")
    private Integer pageview;

    @Expose
    @Column(name = "favoritecount")
    private Integer favoritecount;

    @Expose
    @Column(name = "reviewcount")
    private Integer reviewcount;

    @Expose
    @Column(name = "publishtime")
    private Timestamp publishtime;

    @Expose
    @Column(name = "articletypeid")
    private int articletypeid;

    public Article() {
    }

    public Article(String articleid, String title, String summary, String content, Integer pageview, Integer favoritecount, Integer reviewcount, Timestamp publishtime, int articletypeid) {
        this.articleid = articleid;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.pageview = pageview;
        this.favoritecount = favoritecount;
        this.reviewcount = reviewcount;
        this.publishtime = publishtime;
        this.articletypeid = articletypeid;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPageview() {
        return pageview;
    }

    public void setPageview(Integer pageview) {
        this.pageview = pageview;
    }

    public Integer getFavoritecount() {
        return favoritecount;
    }

    public void setFavoritecount(Integer favoritecount) {
        this.favoritecount = favoritecount;
    }

    public Integer getReviewcount() {
        return reviewcount;
    }

    public void setReviewcount(Integer reviewcount) {
        this.reviewcount = reviewcount;
    }

    public Timestamp getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Timestamp publishtime) {
        this.publishtime = publishtime;
    }

    public int getArticletypeid() {
        return articletypeid;
    }

    public void setArticletypeid(int articletypeid) {
        this.articletypeid = articletypeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (articletypeid != article.articletypeid) return false;
        if (articleid != null ? !articleid.equals(article.articleid) : article.articleid != null) return false;
        if (title != null ? !title.equals(article.title) : article.title != null) return false;
        if (summary != null ? !summary.equals(article.summary) : article.summary != null) return false;
        if (content != null ? !content.equals(article.content) : article.content != null) return false;
        if (pageview != null ? !pageview.equals(article.pageview) : article.pageview != null) return false;
        if (favoritecount != null ? !favoritecount.equals(article.favoritecount) : article.favoritecount != null)
            return false;
        if (reviewcount != null ? !reviewcount.equals(article.reviewcount) : article.reviewcount != null) return false;
        if (publishtime != null ? !publishtime.equals(article.publishtime) : article.publishtime != null) return false;

        return true;
    }

}
