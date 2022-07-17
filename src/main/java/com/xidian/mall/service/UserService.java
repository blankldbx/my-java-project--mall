package com.xidian.mall.service;

import com.xidian.mall.exception.XidianMallException;
import com.xidian.mall.model.pojo.User;

/**
 * @author LDBX
 * UserService
 */
public interface UserService {

    User getUser();

    void register(String userName, String password) throws XidianMallException;

    User login(String userName, String password) throws XidianMallException;

    void updateInformation(User user) throws XidianMallException;

    boolean checkAdminRole(User user);
}
