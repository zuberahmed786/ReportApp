package com.example.Search.controller;


import com.example.Search.entity.SearchInfo;
import com.example.Search.request.SearchRequest;
import com.example.Search.services.SearchService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/excel")
    public void exportExcel(HttpServletResponse response) throws Exception{
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment;filename=plans.xls");
        searchService.exportExcel(response);
    }

    @GetMapping("/pdf")
    public void exportPdf(HttpServletResponse response) throws Exception{
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition","attachment;filename=plans.pdf");
        searchService.exportPdf(response);
    }

    @GetMapping("/search")

    public List<SearchInfo> search(@RequestBody SearchRequest request){

        return searchService.search(request);
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }



}
