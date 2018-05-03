package com.zhc.collaborativeinnovation.vo;

import com.google.gson.annotations.Expose;
import com.zhc.core.vo.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

}
