package com.example.Search.services;


import com.example.Search.entity.SearchInfo;
import com.example.Search.request.SearchRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface SearchService {

    public List<String> getNames();

    public List<String> getStatus();

    public List<SearchInfo> search(SearchRequest request);

    public boolean exportExcel(HttpServletResponse response) throws Exception;

    public boolean exportPdf(HttpServletResponse response) throws Exception;
}
