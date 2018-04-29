package com.zhc.collaborativeinnovation.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "articletype")
public class Articletype implements Serializable {

    @Id
    @Column(name = "articletypeid")
    private int articletypeid;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Articletype that = (Articletype) o;

        if (articletypeid != that.articletypeid) return false;
        if (articletypename != null ? !articletypename.equals(that.articletypename) : that.articletypename != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = articletypeid;
        result = 31 * result + (articletypename != null ? articletypename.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{\n\tarticletypeid : "+articletypeid+",\n\tarticletypename : "+articletypename+"\n}";
    }
}
