package com.springapp.dao;

import com.springapp.common.HibernateDao;
import com.springapp.common.Pagination;
import com.springapp.domain.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDAO extends HibernateDao<Users, Long> {


    public List<Users> getAllUser(){
            return getAll();
    }

    public Pagination<Users> getUsers(Pagination<Users> page){
        String hql = "from Users users order by users.age";
        return findPage(page,hql);
    }

}