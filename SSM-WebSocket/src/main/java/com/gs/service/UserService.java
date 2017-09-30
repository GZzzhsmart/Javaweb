package com.gs.service;

import com.gs.mapping.User;


public interface UserService {

    User login(String name, String password);
}
