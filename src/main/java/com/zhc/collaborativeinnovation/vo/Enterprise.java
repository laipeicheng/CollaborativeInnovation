package com.zhc.collaborativeinnovation.vo;

import com.google.gson.annotations.Expose;
import com.zhc.core.vo.BaseEntity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "enterprise")
public class Enterprise extends BaseEntity {

    public static int REQUEST = 0;
    public static int SUCCESS = 1;
    public static int REAUTH = 2;

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

    @Expose
    @Column(name = "corporation")
    private String corporation;

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

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

}
