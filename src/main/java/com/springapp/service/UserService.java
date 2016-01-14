package com.springapp.service;

import com.springapp.common.Pagination;
import com.springapp.dao.UsersDAO;
import com.springapp.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UsersDAO usersDAO;
    
    public List<Users> ListUsers(){
        return usersDAO.getAllUser();
    }

    public void setUsersDAO(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }


    public Pagination<Users> getUsers(Pagination<Users> page){return  usersDAO.getAll(page);
    }
}