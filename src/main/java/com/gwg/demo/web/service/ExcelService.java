package com.gwg.demo.web.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by
 */
public interface ExcelService {

    /**
     * 1.Excel文件上传
     */
    public void uploadUserInfo(MultipartFile file) throws IOException;


    /**
     * 2.Excel文件下载
     */
    public void downloadUserInfo(OutputStream out, Long betchId) ;




}
