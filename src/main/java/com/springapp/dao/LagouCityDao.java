package com.springapp.dao;

import com.springapp.common.HibernateDao;
import com.springapp.common.Pagination;
import com.springapp.domain.LagouCity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 95 on 2015/12/16.
 */
@Repository
public class LagouCityDao  extends HibernateDao<LagouCity, Long> {

    public List<LagouCity> getAllCitys(){
        return getAll();
    }

    public Pagination<LagouCity> getCitys(Pagination<LagouCity> page){
        String hql = "from LagouCity lagouCity order by lagouCity.id";
        return findPage(page,hql);
    }

}
