package com.gwg.demo.web.util;

import com.csvreader.CsvWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class CSVPoiUtils {
	/**
	 * 导出csv文件(此方法可以保持到本地)
	 * 
	 * @author Jason K
	 * @param fileName
	 *            导出完整路径不加后缀名
	 */
	public static void csv(String fileName, String body) {
		char delimiter = ',';
		try {
			CsvWriter csvOutput = new CsvWriter(fileName + ".csv", delimiter, Charset.forName("GBK"));
			csvOutput.setEscapeMode(CsvWriter.ESCAPE_MODE_DOUBLED);
			// 第一行
			String[] rows = body.split("#");
			// 循环写出数据
			for (String data : rows) {
				csvOutput.write(data);
				csvOutput.endRecord();
			}
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 导出csv文件
	 * 
	 */
	public static void csv(OutputStream out, String fileName, String body) {
		char delimiter = ',';
		try {
			CsvWriter csvOutput = new CsvWriter(out, delimiter, Charset.forName("UTF-8"));
			csvOutput.setEscapeMode(CsvWriter.ESCAPE_MODE_DOUBLED);
			String[] rows = body.split("#");
			// 循环写出数据
			for (String data : rows) {
				String[] cells = data.split(",");
//				csvOutput.write(cells[0]);
				csvOutput.writeRecord(cells);
//				csvOutput.endRecord();
			}
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
