package com.gwg.demo.web.util;

import com.gwg.demo.web.vo.UserVo;
import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.List;

public class ExcelUtil {

    private void csvTitleOrder(List<UserVo> interScoreDtos, MultipartFile file) {
        try {
            StringBuilder builder = new StringBuilder();
            int minColumns = -1;

            if(file.getOriginalFilename().endsWith(".csv")) {
                @SuppressWarnings("resource")
                CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
                String[] strArr = null;
                while((strArr = reader.readNext()) != null) {

                    for(int i = 0 ; i < strArr.length; i ++) {
                        builder.append(strArr[i]);

                        if(i != strArr.length - 1) {
                            builder.append(",");
                        }
                    }
                    builder.append("#");
                }

            }else {
                OPCPackage p = OPCPackage.open(file.getInputStream());
                XLSX2CSV xlsx2csv = new XLSX2CSV(p, builder, minColumns);
                xlsx2csv.process();
                p.close();
            }


            String[] rows = builder.toString().split("#");
            double count = 0;
            double length = rows.length;
            if (!(rows == null || rows.length <= 0)) {

                for (String cellContent : rows) {
                    count++;
                    if (StringUtils.isNotBlank(cellContent)) {
                        cellContent = cellContent.trim();

                        if (StringUtils.isNoneEmpty(cellContent)) {

                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


