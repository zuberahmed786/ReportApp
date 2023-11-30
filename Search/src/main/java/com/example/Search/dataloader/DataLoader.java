package com.example.Search.dataloader;

import com.example.Search.entity.SearchInfo;
import com.example.Search.repository.ClientPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ClientPlanRepo repo;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        repo.deleteAll();


        SearchInfo info = new SearchInfo();
        info.setBenefitAmt(12333.0);
        info.setCitizenName("zuber");
        info.setPlanStatus("Y");
        info.setPlanName("market");


        SearchInfo info1 = new SearchInfo();
        info1.setBenefitAmt(123.0);
        info1.setCitizenName("khan");
        info1.setPlanStatus("Y");
        info1.setPlanName("mjd");



        SearchInfo info2 = new SearchInfo();
        info2.setBenefitAmt(333.0);
        info2.setCitizenName("Lal");
        info2.setPlanStatus("N");
        info2.setPlanName("Num");



        SearchInfo info3 = new SearchInfo();
        info3.setBenefitAmt(333.0);
        info3.setCitizenName("ldkd");
        info3.setPlanStatus("Y");
        info3.setPlanName("kd");


        SearchInfo info4 = new SearchInfo();
        info4.setBenefitAmt(123.0);
        info4.setCitizenName("nddb");
        info4.setPlanStatus("N");
        info4.setPlanName("udd");

        List<SearchInfo> list = Arrays.asList(info,info1,info2,info3,info4);

        repo.saveAll(list);



    }

}

