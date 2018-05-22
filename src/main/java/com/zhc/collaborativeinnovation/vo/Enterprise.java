package com.zhc.collaborativeinnovation.vo;

import com.google.gson.annotations.Expose;
import com.zhc.core.vo.BaseEntity;
import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;

@Entity
@Table(name = "enterprise")
public class Enterprise extends BaseEntity {

    public final static int REQUEST = 0;
    public final static int SUCCESS = 1;
    public final static int REAUTH = 2;

    @Id
    @Expose
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Expose
    @Column(name = "name")
    private String name;

    @Expose
    @Column(name = "summary")
    private String summary;

    @Expose
    @Column(name = "address")
    private String address;

    @Column(name = "license")
    private byte[] license;

    @Expose
    @Column(name = "status")
    private Integer status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "corporation")
    private User corporation;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "publisher")
    private Set<Needs> needsSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getLicense() {
        return license;
    }

    public void setLicense(byte[] license) {
        this.license = license;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getCorporation() {
        return corporation;
    }

    public void setCorporation(User corporation) {
        this.corporation = corporation;
    }

    @JSON(serialize = false)
    public Set<Needs> getNeedsSet() {
        return needsSet;
    }

    public void setNeedsSet(Set<Needs> needsSet) {
        this.needsSet = needsSet;
    }
}
