package com.example.hiringagency.service.impl;

import com.example.hiringagency.DAO.CTMapper;
import com.example.hiringagency.domain.entity.Billing;
import com.example.hiringagency.domain.entity.CareRequests;
import com.example.hiringagency.domain.entity.CareTakerRegistration;
import com.example.hiringagency.domain.entity.CareService;
import com.example.hiringagency.service.CTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CTServiceImpl implements CTService {

    @Autowired
    private CTMapper ctMapper;

    @Override
    public void CTRegister(CareTakerRegistration careTakerRegistration){
        ctMapper.CTRegister(careTakerRegistration);
    }

    @Override
    public List<CareTakerRegistration> selectAllCTs(){
        return ctMapper.selectAllCTs();
    }

    @Override
    public void addRequest(CareRequests careRequests){
        ctMapper.addRequest(careRequests);
    }

    @Override
    public List<CareRequests> selectRequests(Long careTakerId){
        return ctMapper.selectRequests(careTakerId);
    }

    @Override
    public List<CareService> selectPendingService(Long careTakerId){
        return ctMapper.selectPendingService(careTakerId);
    }

    @Override
    public List<CareService> selectTerminateService(Long careTakerId){
        return ctMapper.selectTerminateService(careTakerId);
    }

    @Override
    public List<Billing> selectBilling(Long careTakerId){
        return ctMapper.selectBilling(careTakerId);
    }
}
