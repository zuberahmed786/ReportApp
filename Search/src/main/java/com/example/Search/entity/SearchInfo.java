package com.example.Search.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "citizePlan")
public class SearchInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int citizenId;
     private String citizenName;
     private String gender;
     private String planName;
     private String planStatus;
     private LocalDate planStartDate;
     private LocalDate planEndDate;
     private Double benefitAmt;
     private String denialReason;
     private LocalDate terminatedDate;
     private String terminationRsn;


}
