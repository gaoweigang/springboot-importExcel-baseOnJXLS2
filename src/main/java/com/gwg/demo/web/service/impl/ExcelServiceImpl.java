package com.gwg.demo.web.service.impl;

import com.gwg.demo.web.dto.UserDto;
import com.gwg.demo.web.service.ExcelService;
import com.gwg.demo.web.util.CSVPoiUtils;
import com.gwg.demo.web.util.XLSX2CSV;
import com.gwg.demo.web.vo.UserVo;
import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author
 *
 */
@Component
public class ExcelServiceImpl implements ExcelService {

	private static final Logger log = LoggerFactory.getLogger(ExcelServiceImpl.class);


	@Override
	public void uploadUserInfo(MultipartFile file) throws IOException {
		log.info("文件上传..............");
		List<UserVo> userDtoList = new ArrayList<>();
		csvTitleOrder(userDtoList, file);

	}

	@Override
	public void downloadUserInfo(OutputStream out, Long betchId) {
		String body = "";
		CSVPoiUtils.csv(out, "IntentionScore", body);

	}


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
							log.info(cellContent);

						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
