package com.senatic.siri.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelFileConverter {

    public static List<List<String>> convertSheetInMatrix(MultipartFile file) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        List<List<String>> matrix = new ArrayList<>();
        List<String> rowListed = new ArrayList<>();
        sheet.forEach(row -> {
            row.forEach(cell -> rowListed.add(cell.getStringCellValue()));
            matrix.add(rowListed);
        });
        workbook.close();
        return matrix;
    }

}