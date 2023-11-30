package com.example.Search.utility;

import com.example.Search.entity.SearchInfo;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class PdfGenerator {

    public void generatePdf(HttpServletResponse response, List<SearchInfo> list,File file) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());
        PdfWriter.getInstance(document,new FileOutputStream(file));
        document.open();

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setSize(20);
        font.setColor(Color.RED);
        Paragraph paragraph = new Paragraph("Citizen_Plan",font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

        PdfPTable pdfPTable = new PdfPTable(5);

        pdfPTable.addCell("Id");
        pdfPTable.addCell("Citizen Name");
        pdfPTable.addCell("Plan Name");
        pdfPTable.addCell("Plan Status");
        pdfPTable.addCell("Benefit Amt");


        for (SearchInfo plans:list){
            pdfPTable.addCell(String.valueOf(plans.getCitizenId()));
            pdfPTable.addCell(plans.getCitizenName());
            pdfPTable.addCell(plans.getPlanName());
            pdfPTable.addCell(plans.getPlanStatus());
            pdfPTable.addCell(String.valueOf(plans.getBenefitAmt()));
        }


        document.add(pdfPTable);

        document.close();
    }
}
