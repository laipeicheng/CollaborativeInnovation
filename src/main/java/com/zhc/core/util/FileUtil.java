package com.zhc.core.util;

import com.zhc.core.realms.LoginRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;

import java.io.*;

public class FileUtil {

    /**
     * 上传文件
     *
     * @param file 需要上传的文件
     * @param filename 文件名
     * @return
     */
    public static String saveFile(File file, String filename) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String path = "";
        try {
            inputStream = new FileInputStream(file);
            String dir = ServletActionContext.getServletContext().getRealPath("/image");
            File fileTmp = new File(dir);
            if (!fileTmp.exists()) {
                fileTmp.mkdir();
            }
            Subject subject = SecurityUtils.getSubject();
            LoginRealm.ShiroUser shiroUser = (LoginRealm.ShiroUser) subject.getPrincipal();
            if (shiroUser != null) {
                path = EncryptUtil.encMD5(shiroUser.getUsername(), filename) + ".jpg";
                fileTmp = new File(dir + "/" + path);
                outputStream = new FileOutputStream(fileTmp);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                outputStream.write(bytes);
                outputStream.flush();
                inputStream.close();
                outputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 获取文件
     *
     * @param path 文件路径
     * @return
     */
    public static byte[] getFile(String path) {
        byte[] bytes;
        String dir = ServletActionContext.getServletContext().getRealPath("/image");
        try {
            File file = new File(dir + "/" + path);
            if (file.exists()) {
                bytes = new byte[(int) file.length()];
                InputStream inputStream = new FileInputStream(file);
                inputStream.read(bytes);
                inputStream.close();
                return bytes;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除文件
     * @param path 文件路径
     */
    public static void delFile(String path) {
        String dir = ServletActionContext.getServletContext().getRealPath("/image");
        File file = new File(dir + "/" + path);
        if (file.exists()) {
            file.delete();
        }
    }
}
