package com.example.Search.repository;

import com.example.Search.entity.SearchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientPlanRepo extends JpaRepository<SearchInfo,Integer> {
//
//        @Query("select distinct planName from citizePlan")
//        public List<String> getPlanName();
//
//        @Query("select distinct planStatus from citizePlan")
//        public List<String> getPlanStatus();

}
