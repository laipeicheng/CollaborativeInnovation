package com.zhc.collaborativeinnovation.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class Article implements Serializable {

    @Id
    @Column(name = "articleid")
    private String articleid;

    @Column(name = "title")
    private String title;

    @Column(name = "summary")
    private String summary;

    @Column(name = "content")
    private String content;

    @Column(name = "pageview")
    private Integer pageview;

    @Column(name = "favoritecount")
    private Integer favoritecount;

    @Column(name = "reviewcount")
    private Integer reviewcount;

    @Column(name = "publishtime")
    private Timestamp publishtime;

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

    @Override
    public int hashCode() {
        int result = articleid != null ? articleid.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (pageview != null ? pageview.hashCode() : 0);
        result = 31 * result + (favoritecount != null ? favoritecount.hashCode() : 0);
        result = 31 * result + (reviewcount != null ? reviewcount.hashCode() : 0);
        result = 31 * result + (publishtime != null ? publishtime.hashCode() : 0);
        result = 31 * result + articletypeid;
        return result;
    }

    @Override
    public String toString() {
        return "{\n\tarticleid : "+articleid+",\n\ttitle : "+title+",\n\tsummary : "+summary+",\n\tcontent"+content+",\n\tpageview : "+pageview+",\n\tfavoritecount"+favoritecount+",\n\treviewcount : "+reviewcount+",\n\tpublishtime : "+publishtime+",\n\tarticletypeid : "+articletypeid+"\n}";
    }
}
