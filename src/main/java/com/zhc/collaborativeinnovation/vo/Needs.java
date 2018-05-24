package com.zhc.collaborativeinnovation.vo;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "needs")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Needs {

    public final static int END = 0;
    public final static int START = 1;

    @Id
    @Expose
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Expose
    @Column(name = "title")
    private String title;

    @Expose
    @Column(name = "content")
    private String content;

    @Expose
    @Column(name = "status")
    private Integer status;

    @Expose
    @Column(name = "publishtime")
    private Timestamp publishtime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher")
    private Enterprise publisher;

    public Needs() {
    }

    public Needs(String title, String content, Integer status, Timestamp publishtime) {
        this.title = title;
        this.content = content;
        this.status = status;
        this.publishtime = publishtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Timestamp publishtime) {
        this.publishtime = publishtime;
    }

    public Enterprise getPublisher() {
        return publisher;
    }

    public void setPublisher(Enterprise publisher) {
        this.publisher = publisher;
    }
}
