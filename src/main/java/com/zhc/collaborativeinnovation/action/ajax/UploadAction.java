package com.zhc.collaborativeinnovation.action.ajax;

import com.zhc.core.action.BaseAction;
import com.zhc.core.util.FileUtil;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import java.io.File;

@Namespace("/upload")
@ParentPackage("json-default")
@Controller
public class UploadAction extends BaseAction {

    private File file;

    private String fileContentType;

    private String fileFileName;

    private boolean uploadStatus = false;

    private String fileUrl;

    @Action(value = "license", results = {@Result(type = "json")})
    public String license() {
        String path = FileUtil.saveFile(file, fileFileName);
        if (!"".equals(path)) {
            uploadStatus = true;
            fileUrl = path;
        }
        return SUCCESS;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public boolean isUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(boolean uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
