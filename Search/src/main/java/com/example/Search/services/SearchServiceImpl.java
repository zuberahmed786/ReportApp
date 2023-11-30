package com.example.Search.services;

import com.example.Search.entity.SearchInfo;
import com.example.Search.repository.ClientPlanRepo;
import com.example.Search.request.SearchRequest;
import com.example.Search.utility.EmailSend;
import com.example.Search.utility.ExcelGenerator;
import com.example.Search.utility.PdfGenerator;
import com.lowagie.text.*;

import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private ClientPlanRepo repo;

    @Autowired
    private ExcelGenerator excelGenerator;

    @Autowired
    private PdfGenerator pdfGenerator;

    @Autowired
    private EmailSend emailSend;

    @Override
    public List<String> getNames() {
        return null;
    }

    @Override
    public List<String> getStatus() {
        return null;
    }

    @Override
    public List<SearchInfo> search(SearchRequest request) {

        SearchInfo entity = new SearchInfo();
        if (request.getPlanName()!=null && !"".equals(request.getPlanName().isEmpty())){
            entity.setPlanName(request.getPlanName());
        }

        return repo.findAll(Example.of(entity));
       // return repo.findAll();
    }

    @Override
    public boolean exportExcel(HttpServletResponse response) throws Exception{
          File file = new File("plans.xls");
          List<SearchInfo> list = repo.findAll();
          excelGenerator.generateExcel(response,list,file);

          String subject="Test Mail";
          String body ="For Testing";
          String to ="zuberaye@gmail.com";
          System.out.println("Before Mail send");
          emailSend.sendMail(subject,body,to,file);
          file.delete();
          System.out.println("Mail Send>>>>>");

         return true;
    }

    @Override
    public boolean exportPdf(HttpServletResponse response) throws Exception{
        File file = new File("plans.pdf");
        List<SearchInfo> list = repo.findAll();
        pdfGenerator.generatePdf(response,list,file);

        String subject="Pdf Test Mail";
        String body ="For Pdf Testing";
        String to ="zuberaye@gmail.com";
        System.out.println("Before Mail send");
        emailSend.sendMail(subject,body,to,file);
        file.delete();
        return true;
    }
}
