package com.zhc.collaborativeinnovation.vo;

import com.google.gson.annotations.Expose;
import com.zhc.core.vo.BaseEntity;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "article")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Article extends BaseEntity {

    @Id
    @Expose
    @Column(name = "articleid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int articleid;

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
    @Column(name = "reviewcount")
    private Integer reviewcount;

    @Expose
    @Column(name = "favoritecount")
    private Integer favoritecount;

    @Expose
    @Column(name = "publishtime")
    private Timestamp publishtime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "articletypeid")
    private Articletype articletype;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "articleid")
    private Set<Reply> replySet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author")
    private User author;

    public Article() {
    }

    public Article(String title, String summary, String content, Integer pageview, Integer reviewcount, Integer favoritecount, Timestamp publishtime) {
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.pageview = pageview;
        this.reviewcount = reviewcount;
        this.favoritecount = favoritecount;
        this.publishtime = publishtime;
    }

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
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

    public Articletype getArticletype() {
        return articletype;
    }

    public void setArticletype(Articletype articletype) {
        this.articletype = articletype;
    }

    @JSON(serialize = false)
    public Set<Reply> getReplySet() {
        return replySet;
    }

    public void setReplySet(Set<Reply> replySet) {
        this.replySet = replySet;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getFavoritecount() {
        return favoritecount;
    }

    public void setFavoritecount(Integer favoritecount) {
        this.favoritecount = favoritecount;
    }
}
