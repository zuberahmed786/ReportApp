package com.example.Search.utility;

import com.example.Search.entity.SearchInfo;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ExcelGenerator {

    public void generateExcel(HttpServletResponse response, List<SearchInfo> list,File file) throws IOException {



        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("plansBook");
        Row rowHeader = sheet.createRow(0);
        rowHeader.createCell(0).setCellValue("Id");
        rowHeader.createCell(1).setCellValue("Citizen Name");
        rowHeader.createCell(2).setCellValue("Plan Name");
        rowHeader.createCell(3).setCellValue("Plan Status");
        rowHeader.createCell(4).setCellValue("Benefit Amt");


        int rowIndex=1;
        for (SearchInfo data:list){
            Row rowData = sheet.createRow(rowIndex);
            rowData.createCell(0).setCellValue(data.getCitizenId());
            rowData.createCell(1).setCellValue(data.getCitizenName());
            rowData.createCell(2).setCellValue(data.getPlanName());
            rowData.createCell(3).setCellValue(data.getPlanStatus());
            rowData.createCell(4).setCellValue(data.getBenefitAmt());

            rowIndex++;

        }

        FileOutputStream fos = new FileOutputStream(new File("plans.xls"));
        workbook.write(fos);
        fos.close();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();

    }
}
