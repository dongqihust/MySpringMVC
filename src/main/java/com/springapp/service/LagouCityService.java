package com.springapp.service;

import com.springapp.common.Pagination;
import com.springapp.dao.LagouCityDao;
import com.springapp.domain.LagouCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LagouCityService {

    @Autowired
    LagouCityDao lagouCityDao;
    
    public List<LagouCity> getLagouCitys(){
        return lagouCityDao.getAllCitys();
    }




    public Pagination<LagouCity> getLagouCitys(Pagination<LagouCity> page){return  lagouCityDao.getAll(page);
    }
}