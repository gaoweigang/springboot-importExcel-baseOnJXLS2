package com.gwg.demo.web.controller;

import com.alibaba.fastjson.JSON;
import com.gwg.demo.web.common.Result;
import com.gwg.demo.web.request.DownloadExcelRequest;
import com.gwg.demo.web.service.ExcelService;
import com.gwg.demo.web.service.impl.ExcelServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;


@RestController
@RequestMapping(path = "/excel")
public class ExcelController {

    private static final Logger log = LoggerFactory.getLogger(ExcelController.class);

    @Autowired
    private ExcelService excelService;

    /**
     * Excel上传
     */
    @RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
    public Result upload(MultipartFile file) {
        Result result = new Result();
        try {
             log.info("upload start ...");

             excelService.uploadUserInfo(file);

            return result.success(null);
        } catch (Exception e) {
            return result.error("00001", "i dont known");
        }

    }

    /**
     * 文件下载
     */
    @RequestMapping(value = "/downExcel", method = RequestMethod.GET)
    public void downExcelById(DownloadExcelRequest request, HttpServletResponse response) {
        try {
            log.info("downrecord, param:{}", JSON.toJSONString(request));
            response.setContentType("application/csv;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("IntentionScore.csv", "UTF-8"));
            excelService.downloadUserInfo(response.getOutputStream(), Long.valueOf(null));
            response.getOutputStream().flush();
        } catch (Exception e) {
            log.error("xloan downrecord, Exception", e);
        }
    }




}
