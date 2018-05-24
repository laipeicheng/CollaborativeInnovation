package com.zhc.collaborativeinnovation.vo;

import com.google.gson.annotations.Expose;
import com.zhc.core.vo.BaseEntity;
import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "articletype")
public class Articletype extends BaseEntity {

    @Id
    @Expose
    @Column(name = "articletypeid")
    private int articletypeid;

    @Expose
    @Column(name = "articletypename")
    private String articletypename;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "articletypeid")
    private Set<Article> articleSet;

    public Articletype() {
    }

    public Articletype(int articletypeid, String articletypename) {
        this.articletypeid = articletypeid;
        this.articletypename = articletypename;
    }

    public int getArticletypeid() {
        return articletypeid;
    }

    public void setArticletypeid(int articletypeid) {
        this.articletypeid = articletypeid;
    }

    public String getArticletypename() {
        return articletypename;
    }

    public void setArticletypename(String articletypename) {
        this.articletypename = articletypename;
    }

    @JSON(serialize = false)
    public Set<Article> getArticleSet() {
        return articleSet;
    }

    public void setArticleSet(Set<Article> articleSet) {
        this.articleSet = articleSet;
    }
}
